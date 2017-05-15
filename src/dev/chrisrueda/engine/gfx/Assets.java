package dev.chrisrueda.engine.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	
	
	public static BufferedImage[] playerDown,playUp,playerLeft,playerRight;
	private static int width=32,height=32;
	
	
	public static void init(){
		
	
		
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
