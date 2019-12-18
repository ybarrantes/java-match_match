package game;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import app.AppSound;
import app.Assets;
import enums.EButtonState;
import enums.EButtonType;
import enums.ECardStatus;
import graphics.TransformImage;
import helpers.Sound;
import listeners.ClickListener;

public class Card extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Dimension size = new Dimension(110, 150);
	public Dimension getSize() {
		return size;
	}
	public void setSize(Dimension size) {
		this.size = size;
	}
	
	private ECardStatus status = ECardStatus.Hidden;
	public ECardStatus getStatus() {
		return status;
	}
	public void setStatus(ECardStatus status) {
		this.status = status;
		changeImageIcon();
	}
	
	private BufferedImage imageMatch;	
	
	public BufferedImage getImageMatch() {
		return imageMatch;
	}
	public void setImageMatch(BufferedImage imageMatch) {
		this.imageMatch = imageMatch;
	}
	
	// listener de evento click
	private ClickListener clickListener;
	public void setClickListener(ClickListener listener) {
		this.clickListener = listener;
	}
	
	private String tag;	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	private int index;	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	

	protected Sound soundClick;
	
	public Card() {
		super();
		
		setStatus(ECardStatus.Hidden);		
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		soundClick = new AppSound(Assets.getSoundButtonSwitch());
		soundClick.changeVolumen(2.0f);
		
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Click(null);
			}
			
		});
		
		setVisible(true);
	}
	
	private void changeImageIcon() {
		BufferedImage im;
		boolean rollover = true;
		
		switch(status) {
		case Hidden:
			im = TransformImage.clone(Assets.getImageCard());
			break;
		case Visible:
			im = TransformImage.clone(imageMatch);
			rollover = false;
			break;
		case Match:
			im = TransformImage.clone(imageMatch);
			setEnabled(false);
			rollover = false;
			break;
		default:
			im = TransformImage.clone(Assets.getImageCard());
		}
		
		setIcon(new ImageIcon(TransformImage.scale(im, size)));
		setRolloverIcon((rollover) ? new ImageIcon(TransformImage.scale(Assets.getImageCardOver(), size)) : null);
	}
	
	public void Click(MouseEvent e) {
		if(status.equals(ECardStatus.Hidden)) {
			soundClick.play();
			
			if (clickListener != null)
				clickListener.onClick(e, this);
		}			
	}

}
