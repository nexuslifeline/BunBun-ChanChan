package dev.chrisrueda.engine.gfx;

import java.awt.image.BufferedImage;

public class Animation {
	
	private int speed, index;
	private long lastTime, timer;
	private BufferedImage[] frames;
	
	public Animation(int speed,BufferedImage[] frames){
		this.speed=speed;
		this.frames=frames;	
		//initialize required variables for their initial value
		index=0;
		timer=0;
		lastTime=System.currentTimeMillis();		
	}
	
	
	
	public void tick(){
		timer+=System.currentTimeMillis()-lastTime; //calculate the amount of milliseconds elapsed since last time of execution
		lastTime=System.currentTimeMillis();		
		if(timer>speed){ //if amount of millisecond is enough, change the active frame
			index++;		
			
			timer=0;			
			if(index>=frames.length){ //make sure current frame index is not out of bounds
				index=0;
			}
		}		
	}
	
	
	public BufferedImage getCurrentFrame(){
		return frames[index];
	}



	public void setFrames(BufferedImage[] frames) {
		// TODO Auto-generated method stub
		this.frames=frames;
	}
	

}
