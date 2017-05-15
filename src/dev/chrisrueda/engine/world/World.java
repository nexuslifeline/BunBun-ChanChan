package dev.chrisrueda.engine.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import org.w3c.dom.Element;


import dev.chrisrueda.engine.Game;
import dev.chrisrueda.engine.display.Display;
import dev.chrisrueda.engine.entities.Entity;
import dev.chrisrueda.engine.gfx.GameCamera;
import dev.chrisrueda.engine.gfx.ImageLoader;
import dev.chrisrueda.engine.world.World.MapEntity;


public class World {
	
	private String tileData;
	private int mapCol, mapRow;
	
	
	
	
	private MapLayer[] map;
	private BufferedImage[] sourceImage;
	
	private ArrayList<BufferedImage> tileImage = new ArrayList<>();
	private ArrayList<MapEntity> mapEntities = new ArrayList<>();
	private ArrayList<TileSet> tileSets = new ArrayList<>();
	private ArrayList<Rectangle> collisionBoxes = new ArrayList<>();
	
	


	private final String base = "/worlds/map/";
	
	private int TILEWIDTH = 32, TILEHEIGHT = 32; 
	private int xOffset, yOffset, x, y;	

	
	
	
	
	public class MapEntity{
		public String MapEntityPath;
		public int x, y, width, height;
		
		public MapEntity(String MapEntityPath, int x, int y, int width, int height) {
			this.MapEntityPath = MapEntityPath;
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			
			
		}
		
		public BufferedImage getImage() {
			BufferedImage tmpImg = ImageLoader.loadImage( base + MapEntityPath );
			return tmpImg.getSubimage(0, 0, width, height);
		}
		
		
	}
	
	
	class MapLayer{
		private String tileIDs;
		private int[][] tiles;
		private int layerRow, layerColumn;		
		
		public MapLayer(String tileIDList,int layerRow, int layerColumn){
			this.tileIDs = tileIDList;		
			this.layerRow = layerRow;
			this.layerColumn = layerColumn;	
			
			init();
		}
		
		public void init() {
			String[] tokens = tileIDs.replace("\n", "").replace(" ", "").split(","); //remove spaces then split to array
			tiles = new int[layerRow][layerColumn];
			int counter = 0;			
			for(int row = 0; row < layerRow; row++) {
				for(int col = 0; col < layerColumn; col++) {
					tiles[row][col] = Integer.parseInt( tokens[counter].toString() );		
					counter++;
				}				
			}			
			
		}		
		
	}
	
	
	class TileSet{
		private int fgid, tileHeight, tileWidth, tileCount, columnCount, rowCount;
		private String source , basePath;	
		

		public TileSet(String source, int fgid, int tileHeight, int tileWidth, int tileCount, int columnCount) {
			this.source = source;
			this.fgid = fgid;
			this.tileHeight = tileHeight;
			this.tileWidth = tileWidth;
			this.tileCount = tileCount;
			this.columnCount = columnCount;
			this.rowCount = tileCount / columnCount;
			this.basePath = base + source;
		}	
		
		
		
	}
	
	
	

	

	
	public World(Game game,String path){	
				
		
		Document d = loadXMLDocument("res/worlds/map/world_1.tmx");
		try {
			
			tileSets = readTMXTileSets(d);
			map = getTMXLayers(d);			
			mapEntities = readTMXMapEntities(d);
			collisionBoxes = readTMXCollisionBox(d);
			
			initSourceImage();
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		
		
		//System.out.print(layer.length);
	}
	
	
	public ArrayList<Rectangle> getCollisionBoxes() {
		return collisionBoxes;
	}	
	
	
	public ArrayList<MapEntity> getMapEntity() {
		return mapEntities;
	}


	private void initSourceImage() {
		sourceImage = new BufferedImage[tileSets.size()];	
		int rows = 0; int cols = 0; int id = 0;
		BufferedImage tmp;
		
		for(int i = 0; i < tileSets.size(); i++) {
			
			sourceImage[i] = ImageLoader.loadImage( tileSets.get(i).basePath );	
			
			rows = tileSets.get(i).rowCount;
			cols = tileSets.get(i).columnCount;
			
			for(int y = 0; y < rows; y++) {
				for(int x = 0; x < cols; x++) {					
					tmp = sourceImage[i].getSubimage(x * TILEWIDTH, y * TILEHEIGHT, TILEWIDTH, TILEHEIGHT);					
					tileImage.add(tmp);
				}
			}
			
			
		}
		
		
		
		
	}
	
	private Document loadXMLDocument(String path) {
		Document doc = null;
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();        
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(path);
			doc.getDocumentElement().normalize();
		} catch (ParserConfigurationException | SAXException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return doc;
	}
	
	private ArrayList<Rectangle> readTMXCollisionBox(Document doc){
		ArrayList<Rectangle> cb =  new ArrayList<>();
		NodeList obj = doc.getElementsByTagName("object");

		for (int i = 0; i < obj.getLength(); i++) {
			Element e = (Element) obj.item(i);
					
			cb.add( new Rectangle(Integer.parseInt(e.getAttribute("x")),Integer.parseInt(e.getAttribute("y")),Integer.parseInt(e.getAttribute("width")),Integer.parseInt(e.getAttribute("height"))) );
		}		
		
		return cb;		
	}
	
	
	private ArrayList<TileSet> readTMXTileSets(Document doc) throws ParserConfigurationException, IOException, SAXException {
		ArrayList<TileSet> tileSetList =  new ArrayList<>();
		NodeList nlTileSets = doc.getElementsByTagName("tileset");
			
		//get tileSets
		for (int i = 0; i < nlTileSets.getLength(); i++) {
			Element e = (Element) nlTileSets.item(i);
			Element x = (Element) e.getElementsByTagName("image").item(0);			
			tileSetList.add( new TileSet(x.getAttribute("source"), Integer.parseInt(e.getAttribute("firstgid")) , Integer.parseInt(e.getAttribute("tilewidth")), Integer.parseInt(e.getAttribute("tileheight")), Integer.parseInt(e.getAttribute("tilecount")), Integer.parseInt(e.getAttribute("columns"))) );
		}		
		
		return tileSetList;		
	}
	
	
	private ArrayList<MapEntity> readTMXMapEntities(Document doc) throws ParserConfigurationException, IOException, SAXException {
		ArrayList<MapEntity> mapEntityList = new ArrayList<>();		
		NodeList nList = doc.getElementsByTagName("imagelayer");	
		
		for (int i = 0; i < nList.getLength(); i++) {
			Element e = (Element) nList.item(i);
			Element x = (Element) e.getElementsByTagName("image").item(0);				
			mapEntityList.add( new MapEntity( x.getAttribute("source").toString(), Integer.parseInt(e.getAttribute("offsetx")), Integer.parseInt(e.getAttribute("offsety")), Integer.parseInt(x.getAttribute("width")), Integer.parseInt(x.getAttribute("height")) ) );
		
			//System.out.println(x.getAttribute("source").toString());
		
		}		
		return mapEntityList;		
	}
	
	
	
	
	private MapLayer[] getTMXLayers(Document doc) throws ParserConfigurationException, SAXException, IOException{
		MapLayer[] ml = null;	
		
		NodeList nMap = doc.getElementsByTagName("map"); //returns array of nodes
		Element a = (Element) nMap.item(0);
		
		mapRow = Integer.parseInt( a.getAttribute("height") ); //no. of rows of the map
		mapCol = Integer.parseInt( a.getAttribute("width") ); //no. of columns of the map
		
		TILEHEIGHT = Integer.parseInt( a.getAttribute("tileheight") );
		TILEWIDTH = Integer.parseInt( a.getAttribute("tileheight") );
		
		
		NodeList mapLayers = doc.getElementsByTagName("layer"); //returns array of nodes
		ml = new MapLayer[mapLayers.getLength()];			
		for (int i = 0; i < mapLayers.getLength(); i++) {
							
			Element e = (Element) mapLayers.item(i);		
			
			ml[i] = new MapLayer( e.getTextContent() ,  mapRow , mapCol );			            		

		}		
		return ml;

	}
	
	
	
	public void render(Graphics g){
		int id = 0; 		
		
		int xOffSet = (int) GameCamera.xOffset;
		int yOffSet = (int) GameCamera.yOffset;
		int renderX = 0; 
		int renderY = 0;	
		TileSet t;
		
		
		for(MapLayer m : map) {	
			
			//int drawCounter = 0;
			for(int row = 0; row < mapRow; row++) {
				for(int col = 0; col < mapCol; col++) {
					id =  m.tiles[row][col]; //just breaking the rule of encapsulation here!!! haha
					
					//now we want to know the image we are going to use base on id, 
					//what part of the image we are going to crop (x,y,width,height)
					
					if(id > 0) {
						t = getTileSet(id);
						if(t != null) {
							
							renderX = (col * TILEWIDTH) - xOffSet;
							renderY = (row * TILEHEIGHT) - yOffSet;
							
							if( (renderX + TILEWIDTH > 0 && renderX < Display.width ) && ( renderY + TILEHEIGHT > 0 && renderY < Display.height) ) {
								g.drawImage(tileImage.get(id - 1), renderX, renderY, null);	
								//drawCounter++;
							}							
											
							
						}
					}
					
				}
			}		
			
			//System.out.println("COUNT : " + drawCounter);
			
		}
		
		
	}
	
	
	public TileSet getTileSet(int id) {
		int i = 0;
		for(TileSet t : tileSets) {
			i =  (int) Math.floor( t.fgid / id ); 
			return tileSets.get(i);
		}
		
		return null;
	}
	

	public int getWorldWidth() { //width in pixel
		return this.mapCol * this.TILEWIDTH;
	}
	

	public int getWorldHeight() { //height in pixel
		return this.mapRow * this.TILEHEIGHT;
	}
	
	

	

	

	
	
	
	

}
