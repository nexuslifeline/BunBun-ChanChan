package dev.chrisrueda.engine.states;

import java.awt.Graphics;

import dev.chrisrueda.engine.Game;
import dev.chrisrueda.engine.display.Display;
import dev.chrisrueda.engine.entities.Entity;
import dev.chrisrueda.engine.entities.EntityManager;
import dev.chrisrueda.engine.entities.Player;
import dev.chrisrueda.engine.entities.StaticEntity;
import dev.chrisrueda.engine.gfx.GameCamera;
import dev.chrisrueda.engine.world.World;
import dev.chrisrueda.engine.world.World.MapEntity;

public class GameState extends State {
	
	private World world;
	private Player player;
	private GameCamera gameCam;
	private Display display;
	private EntityManager entityManager;


	
	
	public GameState(Game game){	
		
		world=new World(game,"res/worlds/map_1.txt");
		
		
		gameCam=game.getGameCamera();
		display=game.getDisplay();	
		this.entityManager = new EntityManager();
		
		
		//create an offset rule
		gameCam.setMinxOffset(0);
		gameCam.setMinyOffset(0);	
		
		gameCam.setMaxxOffset(world.getWorldWidth()-(display.getWidth()/2));
		gameCam.setMaxyOffset(world.getWorldHeight()-(display.getHeight()/2));	
		
		Entity e;
		for(MapEntity mapEntity :  world.getMapEntity()) {
			e = new StaticEntity( mapEntity.getImage(), mapEntity.x, mapEntity.y, mapEntity.width, mapEntity.height );
			entityManager.add(e);
		}
		
		player=new Player(game, world, 450, 0);		
		player.showCollisionRectangle(false);
		
		entityManager.add( player );
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
		entityManager.tick();
	
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub	
		
		world.render(g);
		entityManager.render(g);
		
		
	}
	
	
	

}
