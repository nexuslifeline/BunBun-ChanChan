package dev.chrisrueda.engine.tiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.chrisrueda.engine.utils.CollisionBox;

public class Tile {

	protected BufferedImage tile;
	protected final int id;
	
	public static int TILE_WIDTH=64,TILE_HEIGHT=64;
	
	
	private int xDistance=0,yDistance=0,boundsWidth=64,boundsHeight=64;
	private boolean showCollissionRect=false,walkable=true;
	private CollisionBox collisionBox;
	
	
	
	public CollisionBox getCollisionBox() {
		return collisionBox;
	}

	public void setCollisionBox(CollisionBox collisionBox) {
		this.collisionBox = collisionBox;
	}

	public Tile(BufferedImage tile,int id){
		this.tile=tile;
		this.id=id;		
		
		collisionBox=new CollisionBox(0,0,64,64);
	}

	public boolean isWalkable() {
		return walkable;
	}

	public void setWalkable(boolean walkable) {
		this.walkable = walkable;
	}

	public int getId() {
		return id;
	}
	
	public boolean isShowCollissionRect() {
		return showCollissionRect;
	}

	public void setShowCollissionRect(boolean showCollissionRect) {
		this.showCollissionRect = showCollissionRect;
	}

	public void tick(){
		
	}
	
	
	public int getxDistance() {
		return xDistance;
	}

	public void setxDistance(int xDistance) {
		this.xDistance = xDistance;
	}

	public int getyDistance() {
		return yDistance;
	}

	public void setyDistance(int yDistance) {
		this.yDistance = yDistance;
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

	public void render(Graphics g,int x, int y){
		g.drawImage(tile, x, y, null);
		
		//for testing purpose only, so that I can view the rectangle bounds
		if(showCollissionRect){
			collisionBox.update(x + xDistance,y + yDistance,boundsWidth,boundsHeight); //x here is already subtracted to x offset
			
			g.setColor(Color.BLACK);
			g.drawLine(collisionBox.getTop().x1, collisionBox.getTop().y1, collisionBox.getTop().x2, collisionBox.getTop().y2);
			g.drawLine(collisionBox.getLeft().x1, collisionBox.getLeft().y1, collisionBox.getLeft().x2, collisionBox.getLeft().y2);
			g.drawLine(collisionBox.getRight().x1, collisionBox.getRight().y1, collisionBox.getRight().x2, collisionBox.getRight().y2);
			g.drawLine(collisionBox.getDown().x1, collisionBox.getDown().y1, collisionBox.getDown().x2, collisionBox.getDown().y2);

			
		}
	}
	
	
	public int getTileX(int colIndex){ //return the x1 of tile
		return  colIndex*64;
	}
	
	public int getTileY(int rowIndex){ //return the origin y1 of the tile
		return rowIndex*64;
	}
	
	

		
	
	
	

	
	

	

	
	
	
	
}
