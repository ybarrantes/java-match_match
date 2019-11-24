package app;

import java.awt.EventQueue;

import app.menu.AppFrame;

public class App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreenFrame sp = new SplashScreenFrame();
					//Thread.sleep(3500);
					Thread.sleep(1500);
					new AppFrame();
					sp.setVisible(false);
					sp.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
