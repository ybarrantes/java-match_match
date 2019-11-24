package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import app.AppSound;
import app.Assets;
import enums.EButtonState;
import enums.EButtonType;
import enums.EMouseState;
import graphics.TransformImage;
import helpers.Sound;
import listeners.ClickListener;

public class ImageButton extends JComponent {
	
	private static final long serialVersionUID = 1L;
	
	// constantes de clase
	private final float SCALE_FACTOR_ENTERED = 1.05f;
	private final float SCALE_FACTOR_PRESSED = 0.95f;
	private final float OFFSET_ENTERED = 10.0f;
	private final float OFFSET_PRESSED = 10.0f;
	
	// listener de evento click
	private ClickListener clickListener;
	
	private String tag;
	/**
	 * Devuelve un texto personalizado para uso del desarrollador
	 * @return String
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * Asigna un texto personalizado para uso del desarrollador
	 * @param tag
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}


	protected EButtonState state;	
	public EButtonState getState() {
		return state;
	}
	public void setState(EButtonState state) {
		this.state = state;
	}
	

	protected EButtonType type;
	public EButtonType getType() {
		return type;
	}

		
	protected Sound soundOver;
	public Sound getSoundOver() {
		return soundOver;
	}
	public void setSoundOver(Sound soundOver) {
		this.soundOver = soundOver;
	}
	
	
	protected Sound soundClick;
	public Sound getSoundClick() {
		return soundClick;
	}
	public void setSoundClick(Sound soundClick) {
		this.soundClick = soundClick;
	}
	
	protected BufferedImage imageButtonEntered;
	protected BufferedImage imageButtonPressed;
	protected BufferedImage imageButton;
	public BufferedImage getImageButton() {
		return imageButton;
	}
	public void setImageButton(BufferedImage imageButton) {
		this.imageButton = TransformImage.clone(imageButton);
		imageButtonEntered = TransformImage.contrast(this.imageButton, SCALE_FACTOR_ENTERED, OFFSET_ENTERED);
		imageButtonPressed = TransformImage.contrast(this.imageButton, SCALE_FACTOR_PRESSED, OFFSET_PRESSED);
		
		setSize(new Dimension(imageButton.getWidth(), imageButton.getHeight()));
		setPreferredSize(new Dimension(imageButton.getWidth(), imageButton.getHeight()));
		repaint();
	}
	
	
	protected BufferedImage imageButtonOnEntered;
	protected BufferedImage imageButtonOnPressed;
	protected BufferedImage imageButtonOn;
	public BufferedImage getImageButtonOn() {
		return imageButtonOn;
	}
	public void setImageButtonOn(BufferedImage imageButtonOn) {
		this.imageButtonOn = TransformImage.clone(imageButtonOn);
		imageButtonOnEntered = TransformImage.contrast(this.imageButtonOn, SCALE_FACTOR_ENTERED, OFFSET_ENTERED);
		imageButtonOnPressed = TransformImage.contrast(this.imageButtonOn, SCALE_FACTOR_PRESSED, OFFSET_PRESSED);
		
		setSize(new Dimension(imageButtonOn.getWidth(), imageButtonOn.getHeight()));
		setPreferredSize(new Dimension(imageButtonOn.getWidth(), imageButtonOn.getHeight()));
		repaint();
	}
		
	protected BufferedImage imageButtonOffEntered;
	protected BufferedImage imageButtonOffPressed;
	protected BufferedImage imageButtonOff;
	public BufferedImage getImageButtonOff() {
		return imageButtonOff;
	}
	public void setImageButtonOff(BufferedImage imageButtonOff) {
		this.imageButtonOff = TransformImage.clone(imageButtonOff);
		imageButtonOffEntered = TransformImage.contrast(this.imageButtonOff, SCALE_FACTOR_ENTERED, OFFSET_ENTERED);
		imageButtonOffPressed = TransformImage.contrast(this.imageButtonOff, SCALE_FACTOR_PRESSED, OFFSET_PRESSED);
		this.repaint();
	}
	
	protected Component parentGraphicsComponent;	
	public Component getParentGraphicsComponent() {
		return parentGraphicsComponent;
	}
	
	
	
	public void setClickListener(ClickListener listener) {
		this.clickListener = listener;
	}
	
	public void Click(MouseEvent e) {
		//System.out.println("mouseClicked");
		soundClick.play();
		
		if(type == EButtonType.Check) {
			if(state == EButtonState.ON) state = EButtonState.OFF;
			else if (state == EButtonState.OFF) state = EButtonState.ON;
			
			repaint();
		}
		
		if (clickListener != null)
			clickListener.onClick(e);
	}
	
	protected EMouseState mouseState;
	
	
	private void init() {
		this.setDoubleBuffered(true);
		this.clickListener = null; 
		
		state = EButtonState.NONE;
		
		setBackground(new Color(0, 0, 0, 0));
		
		soundOver = new AppSound(Assets.getSoundButtonOver());
		soundClick = new AppSound(Assets.getSoundButtonSwitch());
		soundClick.changeVolumen(2.0f);
		
		imageButton = null;
		imageButtonOn = null;
		imageButtonOff = null;
		
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		mouseState = EMouseState.NONE;
		
		//addMouseListener(new ButtonMouseListener());
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//onClick(e);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				changeMouseState(e, EMouseState.PRESSED);
				Click(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if(mouseState != EMouseState.EXITED) {
					changeMouseState(e, EMouseState.RELEASED);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				changeMouseState(e, EMouseState.ENTERED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeMouseState(e, EMouseState.EXITED);
			}
		});
	}
	
	private void changeMouseState(MouseEvent e, EMouseState state) {
		mouseState = state;
		
		switch(mouseState) {
			case ENTERED:
				soundOver.play();
				break;
			default:
				break;
		}
		
		repaint();
	}

	public ImageButton(Component parentGraphicsComponent, BufferedImage imageButton) {
		this(parentGraphicsComponent, imageButton, (Dimension) null);
	}
	public ImageButton(Component parentGraphicsComponent, BufferedImage imageButton, Dimension size) {
		super();
		init();
		this.type = EButtonType.Button;
		this.parentGraphicsComponent = parentGraphicsComponent;
		if(size == null) {
			setImageButton(imageButton);
		} else {
			setImageButton(TransformImage.scale(imageButton, size));
		}
	}
	
	public ImageButton(Component parentGraphicsComponent, BufferedImage imageButtonOn, BufferedImage imageButtonOff) {
		this(parentGraphicsComponent, imageButtonOn, imageButtonOff, (Dimension) null);
	}
	public ImageButton(Component parentGraphicsComponent, BufferedImage imageButtonOn, BufferedImage imageButtonOff, Dimension size) {
		super();
		init();
		this.type = EButtonType.Check;
		this.parentGraphicsComponent = parentGraphicsComponent;
		state = EButtonState.OFF;
		if(size == null) {
			setImageButtonOn(imageButtonOn);
			setImageButtonOff(imageButtonOff);
		} else {
			setImageButtonOn(TransformImage.scale(imageButtonOn, size));
			setImageButtonOff(TransformImage.scale(imageButtonOff, size));
		}		
	}
	
	private BufferedImage parentImageGraphics = null;
	private BufferedImage getParentGraphics() {
		if(parentImageGraphics == null) {
			BufferedImage img = new BufferedImage(parentGraphicsComponent.getWidth(), parentGraphicsComponent.getHeight(), BufferedImage.TYPE_INT_RGB);
			parentGraphicsComponent.paint(img.getGraphics());
			
			parentImageGraphics = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
			Graphics g = parentImageGraphics.getGraphics();
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this.getBounds().x, this.getBounds().y, this.getBounds().x + getWidth(), this.getBounds().y + getHeight(), null);
			g.dispose();
			
			img = null;
		}
		
		return parentImageGraphics;
	}
	
	@Override
	public void paint(Graphics g) {
	    super.paint(g);
	    
	    g.clearRect(0, 0, getWidth(), getHeight());
	    //g.setColor(Color.red);
	    //g.fillRect(0, 0, getWidth(), getHeight());
	    g.drawImage(getParentGraphics(), 0, 0, null);
	
		BufferedImage img = imageButton;
		
		if(type == EButtonType.Check) {
			if(state == EButtonState.ON) {
				img = imageButtonOn;
			} else if(state == EButtonState.OFF) {
				img = imageButtonOff;
			}
		}
		
		if(img == null) {
			throw new IllegalArgumentException("Debe definir las imagenes al boton");
		}
		
		switch(mouseState) {
			case ENTERED:
			case RELEASED:
				img = imageButtonEntered;
				if(type == EButtonType.Check) {
					if(state == EButtonState.ON) {
						img = imageButtonOnEntered;
					} else if(state == EButtonState.OFF) {
						img = imageButtonOffEntered;
					}
				}
				break;
			case PRESSED:
				img = imageButtonPressed;
				if(type == EButtonType.Check) {
					if(state == EButtonState.ON) {
						img = imageButtonOnPressed;
					} else if(state == EButtonState.OFF) {
						img = imageButtonOffPressed;
					}
				}
				break;
			default:
				break;
		}
		
		g.drawImage(img, 0, 0, null);

		g.dispose();
		img = null;
		
		//System.out.println("pintando boton");
	}	


}
