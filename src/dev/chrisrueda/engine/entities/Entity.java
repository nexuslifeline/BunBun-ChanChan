package dev.chrisrueda.engine.entities;


import java.awt.Graphics;


public abstract class Entity {
	
	protected int xOffset, yOffset;
	protected int x, y, velX, velY, speed = 2, width = 32, height = 32;
	protected int boundsX = 0, boundsY = 0, boundsWidth = 32, boundsHeight = 32;
	
	
	public Entity(int x,int y){
		this.x=x;
		this.y=y;
		
	}
	
	
	public int getBoundsX() {
		return boundsX;
	}


	public void setBoundsX(int boundsX) {
		this.boundsX = boundsX;
	}


	public int getBoundsY() {
		return boundsY;
	}


	public void setBoundsY(int boundsY) {
		this.boundsY = boundsY;
	}


	public int getBoundsWidth() {
		return boundsWidth;
	}


	public void setBoundsWidth(int boundsWidth) {
		this.boundsWidth = boundsWidth;
	}


	public int getBoundsHeight() {
		return boundsHeight;
	}


	public void setBoundsHeight(int boundsHeight) {
		this.boundsHeight = boundsHeight;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
	public abstract void tick();
	
	public abstract void render(Graphics g);

	

	
	
	
	
	

}
