package dev.chrisrueda.engine.world;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import dev.chrisrueda.engine.Game;
import dev.chrisrueda.engine.gfx.GameCamera;
import dev.chrisrueda.engine.tiles.Bridge;
import dev.chrisrueda.engine.tiles.FenceTile;
import dev.chrisrueda.engine.tiles.GrassTile;
import dev.chrisrueda.engine.tiles.River;
import dev.chrisrueda.engine.tiles.Street;
import dev.chrisrueda.engine.tiles.Tile;
import dev.chrisrueda.engine.tiles.TreeTile;

public class World {
	
	public static Tile[] tiles=new Tile[256];
	
	
	private String tileMapNotation;
	private int worldWidth,worldRow;
	private int[][] tileMaps;
	
	private int tileWidth=64,tileHeight=64; //height of crop image 64 x 64 pixels
	private int xOffset,yOffset,x,y;
	
	private Game game;	

	
	private FenceTile fenceTile;
	private TreeTile treeTile;
	private GrassTile grassTile;
	private River riverTile;
	private Bridge  bridgeTile;
	private Street streetTile;
	
	public World(Game game,String path){	
		this.game=game;

		
		//load tile images to tiles array
		grassTile=new GrassTile(10);
		tiles[10]=grassTile;
		grassTile.setxDistance(0);
		grassTile.setyDistance(0);
		grassTile.setBoundsWidth(0); //the width of the rectangle boundary base on the X,Y points set from above
		grassTile.setBoundsHeight(0);//the height of the rectangle boundary base on the X,Y points set from above
		grassTile.setShowCollissionRect(false);
		
		
		
		
		treeTile=new TreeTile(90);
		tiles[90]=treeTile;
		treeTile.setxDistance(0); //the X of rectangle Boundary, 30 here will be added to the Current Tile X coordinate
		treeTile.setyDistance(0); //the Y of rectangle Boundary
		treeTile.setBoundsWidth(64); //the width of the rectangle boundary base on the X,Y points set from above
		treeTile.setBoundsHeight(64);//the height of the rectangle boundary base on the X,Y points set from above		
		treeTile.setShowCollissionRect(false);
		
		
		//---------------------------------------------------------------------------------------
		//					all fence tiles starts width id 40 and up
		
		//fence tile(left) settings, tile class has a default setting but for those tile that are not walkable, we change those default seetings
		fenceTile=new FenceTile(40); //2 is the id of tile, which will be the index of the array which will hold this tile
		tiles[40]=fenceTile;	
		fenceTile.setxDistance(30); //the X of rectangle Boundary, 30 here will be added to the Current Tile X coordinate
		fenceTile.setyDistance(0); //the Y of rectangle Boundary
		fenceTile.setBoundsWidth(6); //the width of the rectangle boundary base on the X,Y points set from above
		fenceTile.setBoundsHeight(64);//the height of the rectangle boundary base on the X,Y points set from above		
		fenceTile.setWalkable(false); //default of tile is walkable, but this tile is not walkable so it as "false"
		fenceTile.setShowCollissionRect(false); //set true to view, collision rectangle-for testing purpose
		
		//fence tile(left) settings, tile class has a default setting but for those tile that are not walkable, we change those default seetings
		fenceTile=new FenceTile(41); //2 is the id of tile, which will be the index of the array which will hold this tile
		tiles[41]=fenceTile;	
		fenceTile.setxDistance(0); //the X of rectangle Boundary, 30 here will be added to the Current Tile X coordinate
		fenceTile.setyDistance(0); //the Y of rectangle Boundary
		fenceTile.setBoundsWidth(35); //the width of the rectangle boundary base on the X,Y points set from above
		fenceTile.setBoundsHeight(17);//the height of the rectangle boundary base on the X,Y points set from above		
		fenceTile.setWalkable(false); //default of tile is walkable, but this tile is not walkable so it as "false"
		fenceTile.setShowCollissionRect(false); //set true to view, collision rectangle-for testing purpose
		
		//fence tile(left) settings, tile class has a default setting but for those tile that are not walkable, we change those default seetings
		fenceTile=new FenceTile(42); //2 is the id of tile, which will be the index of the array which will hold this tile
		tiles[42]=fenceTile;	
		fenceTile.setxDistance(0); //the X of rectangle Boundary, 30 here will be added to the Current Tile X coordinate
		fenceTile.setyDistance(0); //the Y of rectangle Boundary
		fenceTile.setBoundsWidth(63); //the width of the rectangle boundary base on the X,Y points set from above
		fenceTile.setBoundsHeight(17);//the height of the rectangle boundary base on the X,Y points set from above		
		fenceTile.setWalkable(false); //default of tile is walkable, but this tile is not walkable so it as "false"
		fenceTile.setShowCollissionRect(false); //set true to view, collision rectangle-for testing purpose
		
		//fence tile(left) settings, tile class has a default setting but for those tile that are not walkable, we change those default seetings
		fenceTile=new FenceTile(43); //2 is the id of tile, which will be the index of the array which will hold this tile
		tiles[43]=fenceTile;	
		fenceTile.setxDistance(0); //the X of rectangle Boundary, 30 here will be added to the Current Tile X coordinate
		fenceTile.setyDistance(0); //the Y of rectangle Boundary
		fenceTile.setBoundsWidth(0); //the width of the rectangle boundary base on the X,Y points set from above
		fenceTile.setBoundsHeight(0);//the height of the rectangle boundary base on the X,Y points set from above		
		fenceTile.setWalkable(false); //default of tile is walkable, but this tile is not walkable so it as "false"
		fenceTile.setShowCollissionRect(false); //set true to view, collision rectangle-for testing purpose
		
		//fence tile(left) settings, tile class has a default setting but for those tile that are not walkable, we change those default seetings
		fenceTile=new FenceTile(44); //2 is the id of tile, which will be the index of the array which will hold this tile
		tiles[44]=fenceTile;	
		fenceTile.setxDistance(32); //the X of rectangle Boundary, 30 here will be added to the Current Tile X coordinate
		fenceTile.setyDistance(0); //the Y of rectangle Boundary
		fenceTile.setBoundsWidth(6); //the width of the rectangle boundary base on the X,Y points set from above
		fenceTile.setBoundsHeight(64);//the height of the rectangle boundary base on the X,Y points set from above		
		fenceTile.setWalkable(false); //default of tile is walkable, but this tile is not walkable so it as "false"
		fenceTile.setShowCollissionRect(false); //set true to view, collision rectangle-for testing purpose
		
		//fence tile(left) settings, tile class has a default setting but for those tile that are not walkable, we change those default seetings
		fenceTile=new FenceTile(45); //2 is the id of tile, which will be the index of the array which will hold this tile
		tiles[45]=fenceTile;	
		fenceTile.setxDistance(32); //the X of rectangle Boundary, 30 here will be added to the Current Tile X coordinate
		fenceTile.setyDistance(0); //the Y of rectangle Boundary
		fenceTile.setBoundsWidth(32); //the width of the rectangle boundary base on the X,Y points set from above
		fenceTile.setBoundsHeight(16);//the height of the rectangle boundary base on the X,Y points set from above		
		fenceTile.setWalkable(false); //default of tile is walkable, but this tile is not walkable so it as "false"
		fenceTile.setShowCollissionRect(false); //set true to view, collision rectangle-for testing purpose
		
		//fence tile(left) settings, tile class has a default setting but for those tile that are not walkable, we change those default seetings
		fenceTile=new FenceTile(46); //2 is the id of tile, which will be the index of the array which will hold this tile
		tiles[46]=fenceTile;	
		fenceTile.setxDistance(0); //the X of rectangle Boundary, 30 here will be added to the Current Tile X coordinate
		fenceTile.setyDistance(0); //the Y of rectangle Boundary
		fenceTile.setBoundsWidth(64); //the width of the rectangle boundary base on the X,Y points set from above
		fenceTile.setBoundsHeight(16);//the height of the rectangle boundary base on the X,Y points set from above		
		fenceTile.setWalkable(false); //default of tile is walkable, but this tile is not walkable so it as "false"
		fenceTile.setShowCollissionRect(false); //set true to view, collision rectangle-for testing purpose
		
		fenceTile=new FenceTile(47); //2 is the id of tile, which will be the index of the array which will hold this tile
		tiles[47]=fenceTile;	
		fenceTile.setxDistance(32); //the X of rectangle Boundary, 30 here will be added to the Current Tile X coordinate
		fenceTile.setyDistance(0); //the Y of rectangle Boundary
		fenceTile.setBoundsWidth(32); //the width of the rectangle boundary base on the X,Y points set from above
		fenceTile.setBoundsHeight(16);//the height of the rectangle boundary base on the X,Y points set from above		
		fenceTile.setWalkable(false); //default of tile is walkable, but this tile is not walkable so it as "false"
		fenceTile.setShowCollissionRect(false); //set true to view, collision rectangle-for testing purpose
		
		fenceTile=new FenceTile(48); //2 is the id of tile, which will be the index of the array which will hold this tile
		tiles[48]=fenceTile;	
		fenceTile.setxDistance(32); //the X of rectangle Boundary, 30 here will be added to the Current Tile X coordinate
		fenceTile.setyDistance(0); //the Y of rectangle Boundary
		fenceTile.setBoundsWidth(32); //the width of the rectangle boundary base on the X,Y points set from above
		fenceTile.setBoundsHeight(16);//the height of the rectangle boundary base on the X,Y points set from above		
		fenceTile.setWalkable(false); //default of tile is walkable, but this tile is not walkable so it as "false"
		fenceTile.setShowCollissionRect(false); //set true to view, collision rectangle-for testing purpose
		
		fenceTile=new FenceTile(49); //2 is the id of tile, which will be the index of the array which will hold this tile
		tiles[49]=fenceTile;	
		fenceTile.setxDistance(32); //the X of rectangle Boundary, 30 here will be added to the Current Tile X coordinate
		fenceTile.setyDistance(0); //the Y of rectangle Boundary
		fenceTile.setBoundsWidth(32); //the width of the rectangle boundary base on the X,Y points set from above
		fenceTile.setBoundsHeight(16);//the height of the rectangle boundary base on the X,Y points set from above		
		fenceTile.setWalkable(false); //default of tile is walkable, but this tile is not walkable so it as "false"
		fenceTile.setShowCollissionRect(false); //set true to view, collision rectangle-for testing purpose
		
	
		//---------------------------------------------------------------------------------------
		//					all street tiles starts width id 20 and up
		//fence tile(left) settings, tile class has a default setting but for those tile that are not walkable, we change those default seetings
		streetTile=new Street(50); //2 is the id of tile, which will be the index of the array which will hold this tile
		tiles[50]=streetTile;	
		streetTile.setxDistance(0); //the X of rectangle Boundary, 30 here will be added to the Current Tile X coordinate
		streetTile.setyDistance(0); //the Y of rectangle Boundary
		streetTile.setBoundsWidth(0); //the width of the rectangle boundary base on the X,Y points set from above
		streetTile.setBoundsHeight(0);//the height of the rectangle boundary base on the X,Y points set from above		
		streetTile.setWalkable(false); //default of tile is walkable, but this tile is not walkable so it as "false"
		streetTile.setShowCollissionRect(false); //set true to view, collision rectangle-for testing purpose
		
		
		
		
		//---------------------------------------------------------------------------------------
		//					all river tiles starts width id 20 and up
		riverTile=new River(20);
		tiles[20]=riverTile;
		riverTile.setxDistance(0); //the X of rectangle Boundary, 30 here will be added to the Current Tile X coordinate
		riverTile.setyDistance(8); //the Y of rectangle Boundary
		riverTile.setBoundsWidth(64); //the width of the rectangle boundary base on the X,Y points set from above
		riverTile.setBoundsHeight(56);//the height of the rectangle boundary base on the X,Y points set from above	
		riverTile.setShowCollissionRect(false);
		
		riverTile=new River(21);
		tiles[21]=riverTile;		
		riverTile.setShowCollissionRect(false);
		
		riverTile=new River(22);
		tiles[22]=riverTile;		
		riverTile.setShowCollissionRect(false);
		//---------------------------------------------------------------------------------------
		
		
		bridgeTile=new Bridge(30);
		tiles[30]=bridgeTile;
		bridgeTile.setxDistance(0); //the X of rectangle Boundary, 30 here will be added to the Current Tile X coordinate
		bridgeTile.setyDistance(7); //the Y of rectangle Boundary
		bridgeTile.setBoundsWidth(50); //the width of the rectangle boundary base on the X,Y points set from above
		bridgeTile.setBoundsHeight(57);//the height of the rectangle boundary base on the X,Y points set from above	
		bridgeTile.setShowCollissionRect(false);
		
		bridgeTile=new Bridge(31);
		tiles[31]=bridgeTile;
		bridgeTile.setxDistance(0); //the X of rectangle Boundary, 30 here will be added to the Current Tile X coordinate
		bridgeTile.setyDistance(0); //the Y of rectangle Boundary
		bridgeTile.setBoundsWidth(50); //the width of the rectangle boundary base on the X,Y points set from above
		bridgeTile.setBoundsHeight(56);//the height of the rectangle boundary base on the X,Y points set from above	
		bridgeTile.setShowCollissionRect(false);
		
		bridgeTile=new Bridge(32);
		tiles[32]=bridgeTile;
		bridgeTile.setxDistance(0); //the X of rectangle Boundary, 30 here will be added to the Current Tile X coordinate
		bridgeTile.setyDistance(0); //the Y of rectangle Boundary
		bridgeTile.setBoundsWidth(0); //the width of the rectangle boundary base on the X,Y points set from above
		bridgeTile.setBoundsHeight(0);//the height of the rectangle boundary base on the X,Y points set from above	
		bridgeTile.setShowCollissionRect(true);
		
		bridgeTile=new Bridge(33);
		tiles[33]=bridgeTile;
		bridgeTile.setxDistance(10); //the X of rectangle Boundary, 30 here will be added to the Current Tile X coordinate
		bridgeTile.setyDistance(9); //the Y of rectangle Boundary
		bridgeTile.setBoundsWidth(54); //the width of the rectangle boundary base on the X,Y points set from above
		bridgeTile.setBoundsHeight(55);//the height of the rectangle boundary base on the X,Y points set from above	
		bridgeTile.setShowCollissionRect(false);
		
		
		bridgeTile=new Bridge(34);
		tiles[34]=bridgeTile;
		bridgeTile.setxDistance(10); //the X of rectangle Boundary, 30 here will be added to the Current Tile X coordinate
		bridgeTile.setyDistance(0); //the Y of rectangle Boundary
		bridgeTile.setBoundsWidth(54); //the width of the rectangle boundary base on the X,Y points set from above
		bridgeTile.setBoundsHeight(55);//the height of the rectangle boundary base on the X,Y points set from above	
		bridgeTile.setShowCollissionRect(false);
		
		tileMapNotation=readTileMapNotationAsString(path); //read the string notation of tile map		
		init();
	}
	
	private String readTileMapNotationAsString(String path){
		StringBuilder builder=new StringBuilder();				
		try{
			BufferedReader br=new BufferedReader(new FileReader(path));
			String line;			
			while((line=br.readLine())!=null){
				
				builder.append(line+"\n");
			}		
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}		
		return builder.toString();
	}
	
	public void init(){		
		String[] tileMapTokens=tileMapNotation.split("\\s+");
		worldRow=tileMapNotation.split("\n").length-1; //split each \n to count the no. of tile vertically minus 1 
															//because the first line is the starting row, col of the player
		
		worldWidth=tileMapNotation.split("\n")[worldRow].split(" ").length;//count the last row of the line base on worldRow 
																				//to count the no. of tile horizontally
		
		tileMaps=new int[worldWidth][worldRow];
		int ctr=2; //because the first two characters are the row and column of the player
		
		for(int row=0;row<worldRow;row++){
			for(int col=0;col<worldWidth;col++){	 //inner loop here is x because we need to fill the first dimension of the array first
											//before going to the second dimension
				
				tileMaps[col][row]=Integer.parseInt(tileMapTokens[ctr]); //each token hold id of tile / index of Tile Array
				
				ctr++;				
			}
		}

		
	}
	
	
	public void render(Graphics g){		
		
		xOffset=(int)GameCamera.xOffset; //get Current X offset value
		yOffset=(int)GameCamera.yOffset; //get Current Y offset value
		
		int index;		
		
		for(int col=0;col<worldWidth;col++){				
			for(int row=0;row<worldRow;row++){
				index=tileMaps[col][row]; //tileMap array holds the id that came from Map Text file, id is also the same index used on Tile Array
				x=(col*tileWidth)-xOffset;
				y=(row*tileHeight)-yOffset;
				
				//for rendering efficiency, tile should not be drawn if if X coordinates of the TILE is 
				//less than 0 which is negative x and not greater than the WIDTH of the screen.. then same is true of Y coordinate and HEIGHT
				if((x+Tile.TILE_WIDTH>=0 && x<=game.getDisplay().getWidth()) && (y+Tile.TILE_HEIGHT>=0 && y<=game.getDisplay().getHeight() )){
					tiles[index].render(g,x,y); //column times tileWidth will convert column to pixel from Min X(0) to Current X
					
				}
				
			}					
		}
		
	}

	public int getWorldWidth() { //width in pixel
		return this.worldWidth*this.tileWidth;
	}
	

	public int getWorldHeight() { //height in pixel
		return this.worldRow*this.tileHeight;
	}
	
	public Tile getCurrentTile(int row,int col){		
		int index=tileMaps[col][row];
		
		return tiles[index];
	}

	

	

	
	
	
	

}
