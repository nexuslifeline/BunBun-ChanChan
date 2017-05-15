package dev.chrisrueda.engine.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;


public class EntityManager {
	
	private ArrayList<Entity> entities = new ArrayList<>();
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {

		@Override
		public int compare(Entity a, Entity b) {
			// TODO Auto-generated method stub
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight()) {
				return -1;
			}else {
				return 1;
			}
		}
	};
	
	
	public void tick() {
		for(Entity e : entities) {
			e.tick();
		}
		entities.sort( renderSorter );
	}
	
	public void render(Graphics g) {
		for(Entity e : entities) {
			e.render(g);
		}
	}
	
	public void add(Entity e) {
		entities.add(e);
	}
	
	

}
