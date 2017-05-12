package dev.chrisrueda.engine.tiles;



import dev.chrisrueda.engine.gfx.Assets;

public class FenceTile extends Tile {
	
	public FenceTile(int id) {
		
		super(
				(id==40?Assets.fenceLeft:(id==42?Assets.fenceBottomBody:(id==43?Assets.fenceBody:(id==44?Assets.fenceRight:(id==45?Assets.fenceRightBottom:(id==46?Assets.fenceBottom:(id==47?Assets.fenceTopLeft:(id==48?Assets.fenceTopRight:(id==49?Assets.fenceBodyBottom:Assets.fenceLeftBottom)))))))))
				,
			id); //we know here that GrassTile class need grass tile sheet
		
		// TODO Auto-generated constructor stub
	}
	
	

}
