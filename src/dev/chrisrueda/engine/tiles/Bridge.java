package dev.chrisrueda.engine.tiles;



import dev.chrisrueda.engine.gfx.Assets;

public class Bridge extends Tile {

	public Bridge(int id) {
		super((id==30?Assets.bridgeLeft:(id==31?Assets.bridgeLeftBottom:(id==32?Assets.bridgeBodyBottom:(id==33?Assets.bridgeRight:Assets.bridgeBodyRight)))), id);
		// TODO Auto-generated constructor stub
	}

}
