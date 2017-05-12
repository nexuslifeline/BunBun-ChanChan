package dev.chrisrueda.engine.tiles;



import dev.chrisrueda.engine.gfx.Assets;

public class River extends Tile {

	public River(int id) {
		super((id==20?Assets.riverTop:(id==21?Assets.riverBody:Assets.riverBottom)), id);
		// TODO Auto-generated constructor stub
	}

}
