package com.game;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Application extends JFrame {
	public Application() {
		initUI();
	}
	
	private void initUI() {
		add(new board());
		setSize(500, 500);
		
		setTitle("Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		
		
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Application ex = new Application();
				ex.setVisible(true);
			}
		});
	}

}
