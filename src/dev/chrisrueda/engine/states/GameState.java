package dev.chrisrueda.engine.states;

import java.awt.Graphics;

import dev.chrisrueda.engine.Game;
import dev.chrisrueda.engine.display.Display;
import dev.chrisrueda.engine.entities.Player;
import dev.chrisrueda.engine.gfx.GameCamera;
import dev.chrisrueda.engine.world.World;

public class GameState extends State {
	
	private World world;
	private Player player;
	private GameCamera gameCam;
	private Display display;


	
	
	public GameState(Game game){	
		
		world=new World(game,"res/worlds/map_1.txt");
		player=new Player(game,world,450,0);		
		player.showCollisionRectangle(true);
		
		gameCam=game.getGameCamera();
		display=game.getDisplay();	
		
		
		//create an offset rule
		gameCam.setMinxOffset(0);
		gameCam.setMinyOffset(0);	
		
		gameCam.setMaxxOffset(world.getWorldWidth()-(display.getWidth()/2));
		gameCam.setMaxyOffset(world.getWorldHeight()-(display.getHeight()/2));	
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
		player.tick();
	
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub	
		
		world.render(g);		
		player.render(g);
		
		
	}
	
	
	

}
