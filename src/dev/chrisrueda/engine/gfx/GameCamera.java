package dev.chrisrueda.engine.gfx;

import dev.chrisrueda.engine.Game;
import dev.chrisrueda.engine.display.Display;
import dev.chrisrueda.engine.entities.Entity;

public class GameCamera {
	public static float xOffset,yOffset;
	private Display display;
	
	private int maxxOffset,maxyOffset,minxOffset,minyOffset;
	private int entityCurrentX,entityCurrentY,displyHalfWidth,displayHalfHeight;
	
	public GameCamera(Game game,float xOffset,float yOffset){
		GameCamera.xOffset=xOffset;
		GameCamera.yOffset=yOffset;
		
		display=game.getDisplay();
	}
	
	
	//**************************************************************************************
	//				Camera Rule
	public void setMaxxOffset(int maxxOffset) {
		this.maxxOffset = maxxOffset;
	}	

	public void setMaxyOffset(int maxyOffset) {
		this.maxyOffset = maxyOffset;
	}	

	public void setMinxOffset(int minxOffset) {
		this.minxOffset = minxOffset;
	}

	public void setMinyOffset(int minyOffset) {
		this.minyOffset = minyOffset;
	}
	//**************************************************************************************
	
	
	public int getXOffset(Entity e) {
		entityCurrentX=e.getX();
		displyHalfWidth=display.getWidth()/2;
		xOffset=entityCurrentX-(display.getWidth()/2);
		
		//Apply the Rule specified on offset
		//make sure xOffset is not less than or equal to zero or greater than display width
		if(xOffset<=minxOffset){
			xOffset=0;
		}
		
		//this rule gave me headache!! hahaha
		//It takes 1 and half hours before I solved it.. haha
		//@4/8/2017 12:15PM to 1:39PM
		if(entityCurrentX>=maxxOffset){
			xOffset=maxxOffset-displyHalfWidth;
		}
		
		return (int)xOffset;
	}
	
	

	public int getYOffset(Entity e){		
		//entity here is the player
		entityCurrentY=e.getY();	
		displayHalfHeight=display.getHeight()/2;	
		yOffset=entityCurrentY-(display.getHeight()/2);	
		
		//make sure yOffset is not less than or equal to zero or greater than display height
		if(yOffset<=minyOffset) yOffset=0;
		if(entityCurrentY>=maxyOffset) yOffset=maxyOffset-displayHalfHeight;
			
		return (int)yOffset;
		
	}
	
	

}
