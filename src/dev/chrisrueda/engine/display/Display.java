package dev.chrisrueda.engine.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import dev.chrisrueda.engine.input.KeyManager;

public class Display {
	
	private JFrame frame;
	private Canvas canvas;	
	
	private String title;
	public static int width,height;
	
	
	public Display(String title,int width,int height){
		this.title=title;
		Display.width=width;
		Display.height=height;	
		
	}
	
	public int getWidth() {
		return width;
	}

	
	public int getHeight() {
		return height;
	}

	

	public void start(){
		frame=new JFrame(title);
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);		
		
		canvas=new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setFocusable(false);
		
		//add event listener on JFrame		
		frame.addKeyListener(KeyManager.getInstance());
		
		frame.add(canvas);
		frame.pack();		
		
		
	}

	public Canvas getCanvas() {
		return canvas;
	}
	


	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	

}
