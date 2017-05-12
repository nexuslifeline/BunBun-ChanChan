package dev.chrisrueda.engine;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import dev.chrisrueda.engine.display.Display;
import dev.chrisrueda.engine.gfx.Assets;
import dev.chrisrueda.engine.gfx.GameCamera;
import dev.chrisrueda.engine.states.GameState;
import dev.chrisrueda.engine.states.StateManager;

public class Game implements Runnable {
	private  Display display;
	
	private final String displayTitle="BunBun & ChanChan";
	private int displayWidth=900,displayHeight=550;
	private GameCamera gameCamera;

	


	private Thread thread;
	private Boolean running=false;
	
	private Graphics g;
	private BufferStrategy bs;
	
	private StateManager stateManager;
	
	
	public Game(){
		display=new Display(displayTitle,displayWidth,displayHeight); //we need the title of our main window, the width and also the height
		display.start(); //show the window
	
		gameCamera=new GameCamera(this, 0, 0); //0,0 as initial value to retain to its original coordinates without offset
		
		Assets.init(); //load image resources	
		
		stateManager=new StateManager();
		stateManager.setCurrentState(new GameState(this)); //set the current state of the application
			
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}


	public void setGameCamera(GameCamera gameCamera) {
		this.gameCamera = gameCamera;
	}

	
	public Display getDisplay(){
		return display;
	}
	
	private void tick(){ 
		
		if(stateManager.getCurrentState()!=null){			
			stateManager.getCurrentState().tick();
		}	
	}
	
	private void render(){
		bs=display.getCanvas().getBufferStrategy();
		if(bs==null){
			display.getCanvas().createBufferStrategy(3); //buffer is a hidden screen, to avoid flickering we must load images behind the scenes
			return;
		}
		
		g=bs.getDrawGraphics();
		g.clearRect(0, 0, displayWidth, displayHeight); //always clear the screen before drawing
		//************************draw here**************************
		
		if(stateManager.getCurrentState()!=null){			
			stateManager.getCurrentState().render(g);
		}			
		
		//***********************************************************		
		bs.show();
		g.dispose();
	}
	
	public void run(){		
		
		int frames = 60;
		int second = 1;
		long secondsInNano = 1000000000; //the amount of nanotime in 1 second
		
		int fps= frames /  second;	// frames per second	
		
		double nanoPerFrame = secondsInNano / fps; //this is to get the amount of nanotime per 1 frame (60f / 1000000000 =  1 frame / x) , we should find x which is the nanotime per frame
		
		double delta = 0;	
		//double accumulator=0;
		long timer = 0;
		long elapseTime = 0;
		int ctrFrame = 0;
		
		
		long newTime = 0;
		long lastTime = System.nanoTime();
		
		while(running){
			newTime=System.nanoTime();
			elapseTime = newTime - lastTime;
			
			//accumulator = elapseTime / nanoPerFrame;
			
			delta += elapseTime;
			timer += elapseTime;
			
			lastTime = newTime;
			
			if(delta >= nanoPerFrame){ //if delta time reached the amount of threshold which is the nanotime per frame, call tick and render methods
				tick();
				render();
				
				ctrFrame++;
				delta=0;				
			}
			
			if(timer >= secondsInNano){
				System.out.println("Ticks : "+ctrFrame);
				timer = 0;
				ctrFrame = 0;
			}
			
			
		}
		
		stop();
		
	}
	
	
	public synchronized void start(){
		if(!running){ //make sure, application is not running
			running=true;
			thread=new Thread(this);
			thread.start();
		}		
	}
	
	
	public synchronized void stop(){
		if(running){ //make sure that application is running
			running=false;
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}
