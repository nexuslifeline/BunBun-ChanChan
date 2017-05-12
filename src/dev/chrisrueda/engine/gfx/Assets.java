package dev.chrisrueda.engine.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage grass,fenceLeft,fenceLeftBottom,fenceBottomBody,fenceBody,fenceRight,fenceTopRight,fenceTopLeft,fenceRightBottom,fenceBodyBottom,fenceBottom,
								grassWithTree,riverTop,riverBody,riverBottom,
								bridgeLeft,bridgeRight,bridgeBody,
								bridgeLeftBottom,bridgeBodyBottom,bridgeBodyRight,
								street;
	
	public static BufferedImage[] playerDown,playUp,playerLeft,playerRight;
	private static int width=32,height=32;
	
	
	public static void init(){
		
		
		SpriteSheet sheetTiles=new SpriteSheet("/sprites.png");	
		
		grass=sheetTiles.crop(1, 1);		
		grassWithTree=sheetTiles.crop(1, 2);
		
		fenceLeft=sheetTiles.crop(1, 3);	
		fenceBottomBody=sheetTiles.crop(2, 2);
		fenceLeftBottom=sheetTiles.crop(2, 3);		
		fenceBody=sheetTiles.crop(1, 4);
		fenceRight=sheetTiles.crop(1, 5);
		fenceRightBottom=sheetTiles.crop(2,5);	
		fenceBottom=sheetTiles.crop(2,6);	
		
		fenceBodyBottom=sheetTiles.crop(4,2);	
		fenceTopLeft=sheetTiles.crop(4,3);	
		fenceTopRight=sheetTiles.crop(4,5);	
		
		street=sheetTiles.crop(3,2);	

		
		riverTop=sheetTiles.crop(1, 8);
		riverBody=sheetTiles.crop(2, 8);
		riverBottom=sheetTiles.crop(3, 8);
		
		bridgeLeft=sheetTiles.crop(1, 10);
		bridgeBody=sheetTiles.crop(1, 11);
		bridgeRight=sheetTiles.crop(1, 12);
		
		bridgeLeftBottom=sheetTiles.crop(3, 10);
		bridgeBodyBottom=sheetTiles.crop(3, 11);
		bridgeBodyRight=sheetTiles.crop(3, 12);
		
	
		
		
		//sprite sheet of the player
		SpriteSheet sheetChan=new SpriteSheet("/chan.png");	
		
		playerDown=new BufferedImage[3];
		playerDown[0]=sheetChan.crop(1, 1,width,height);
		playerDown[1]=sheetChan.crop(1, 2,width,height);
		playerDown[2]=sheetChan.crop(1, 3,width,height);
		
		playerLeft=new BufferedImage[3];
		playerLeft[0]=sheetChan.crop(2, 1,width,height);
		playerLeft[1]=sheetChan.crop(2, 2,width,height);
		playerLeft[2]=sheetChan.crop(2, 3,width,height);
		
		playerRight=new BufferedImage[3];
		playerRight[0]=sheetChan.crop(3, 1,width,height);
		playerRight[1]=sheetChan.crop(3, 2,width,height);
		playerRight[2]=sheetChan.crop(3, 3,width,height);
		
		playUp=new BufferedImage[3];
		playUp[0]=sheetChan.crop(4, 1,width,height);
		playUp[1]=sheetChan.crop(4, 2,width,height);
		playUp[2]=sheetChan.crop(4, 3,width,height);
		
		
	}

}
