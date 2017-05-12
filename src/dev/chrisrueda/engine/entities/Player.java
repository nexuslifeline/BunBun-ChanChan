package dev.chrisrueda.engine.entities;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import dev.chrisrueda.engine.Game;
import dev.chrisrueda.engine.display.Display;
import dev.chrisrueda.engine.gfx.Animation;
import dev.chrisrueda.engine.gfx.Assets;
import dev.chrisrueda.engine.gfx.GameCamera;
import dev.chrisrueda.engine.input.KeyManager;
import dev.chrisrueda.engine.world.World;

public class Player extends Entity {
	

	private World world;
	//private KeyManager keyManager;
	private GameCamera gameCamera;	
	
	private Animation animation;

	private int xDistanceFromBaseX=0,yDistanceFromBaseY=0,boundsWidth=32,boundsHeight=32;
	private boolean showCollissionRect=false;

	
	private Rectangle bounds;
	
	public Player(Game game,World world,int x,int y){
		super(x,y);
		
		this.x=x;
		this.y=y;		
		
		this.world=world;
		
		this.gameCamera=game.getGameCamera();
		
		//this.keyManager=display.getKeyManager();			
		
		animation=new Animation(300,Assets.playerDown);		
		//set default collision bounds
		bounds=new Rectangle(x, y, boundsWidth, boundsHeight);	

	
	}
	
	

	public void setXDistanceFromBaseX(int xDistance) {
		this.xDistanceFromBaseX = xDistance;
	}
	

	public void setYDistanceFromBaseY(int yDistance) {
		this.yDistanceFromBaseY = yDistance;
	}

	

	//this is to prevent the player going beyond the window width and height
	public void restrictBounds(){
		
		
		
		if(x<=0){
			x=0;
		}
				
		if(y<=0){
			y=0;
		}
				
		if(y>=world.getWorldHeight() - height){ //minus 32 including the height of the player
			y = world.getWorldHeight() - height;
		}
				
		if(x>=world.getWorldWidth() - width){ //minus 32 including the width of the player
			x = world.getWorldWidth() - width;
		}
				
	}
	

	
	

	@Override
	public void tick() {		
		
		if(KeyManager.getInstance().isKeyDown(KeyEvent.VK_UP)){
			animation.setFrames(Assets.playUp);
			animation.tick(); //trigger regularly the switching of BufferedImage Frame to show the animation		
			
			y-=speed;
			
		}else if(KeyManager.getInstance().isKeyDown(KeyEvent.VK_DOWN)){
			animation.setFrames(Assets.playerDown);
			animation.tick(); //trigger regularly the switching of BufferedImage Frame to show the animation		
			
			y+=speed;
			
		}else if(KeyManager.getInstance().isKeyDown(KeyEvent.VK_LEFT)){
			animation.setFrames(Assets.playerLeft);
			animation.tick(); //trigger regularly the switching of BufferedImage Frame to show the animation		
			
			x-=speed;
			
		}else if(KeyManager.getInstance().isKeyDown(KeyEvent.VK_RIGHT)){			
			animation.setFrames(Assets.playerRight);
			animation.tick(); //trigger regularly the switching of BufferedImage Frame to show the animation		
			
			x+=speed;
			
		}	
		
		
		restrictBounds();
		
		
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
		//get current offset of x and y so that player will be always at center
		xOffset=(int)gameCamera.getXOffset(this);
		yOffset=(int)gameCamera.getYOffset(this);	
		
		//draw the current frame, produce by the animation class
		g.drawImage(animation.getCurrentFrame(), x-xOffset, y-yOffset, null);
		
		//when we render, bounds x and y should also be updated
		bounds.x=x+xDistanceFromBaseX-xOffset;
		bounds.y=y+yDistanceFromBaseY-yOffset;
		bounds.width=boundsWidth;
		bounds.height=boundsHeight;
		
		if(showCollissionRect) { //if this setting is set to true, show rectangle line
			g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
		}
		
	
		
	}

	public void showCollisionRectangle(boolean b) {
		// TODO Auto-generated method stub
		showCollissionRect=b;
	}

}
