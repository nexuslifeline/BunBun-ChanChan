package dev.chrisrueda.engine.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage imageSheet;
	
	public SpriteSheet(BufferedImage imageSheet){
		this.imageSheet=imageSheet;
	}
	
	public SpriteSheet(String path){
		this.imageSheet=ImageLoader.loadImage(path);
	}
	
	public BufferedImage crop(int row,int col,int width,int height){
		//the images for every grid is 32x32 pixels
		return imageSheet.getSubimage((col*32)-32, (row*32)-32, width, height);
	}
	
	public BufferedImage crop(int row,int col){
		//the images for every grid is 32x32 pixels
		return imageSheet.getSubimage((col*64)-64, (row*64)-64, 64, 64);
	}
	
	

}
