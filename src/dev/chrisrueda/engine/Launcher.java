package dev.chrisrueda.engine;



public class Launcher {
	
	
	public static void main(String[] args){
	
		
		Game game=new Game();
		game.start(); //start methods will always call the function run because it implements Runnable
	}
	
}
