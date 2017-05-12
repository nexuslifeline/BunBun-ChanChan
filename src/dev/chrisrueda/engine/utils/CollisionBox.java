package dev.chrisrueda.engine.utils;

import java.awt.Rectangle;



public class CollisionBox {	
	public int boundsX,boundsY,width,height;
	
	private Line top;
	private Line left;
	private Line right;
	private Line down;
	
	public class Line{
		public int x1;
		public int y1;
		public int x2;
		public int y2;
	}
	
	
	public CollisionBox(int x,int y,int width,int height){
		
		update(x,y,width,height);		
	}
	
	public void update(int x,int y,int width,int height){	
		
		this.boundsX = x;
		this.boundsY = y;	
		
		height--; //not sure why this happens, but if I did not subtract 1 pixel my bottom line is not showing
		width--; //not sure why this happens, but if I did not subtract 1 pixel my right line is not showing
		
		this.width=width; 
		this.height=height; 
		
		top=new Line();
		left=new Line();
		right=new Line();
		down=new Line();
		
		//we are creating a box, so we need a top, left, right, down line representation	
		top.x1 = x;
		top.y1 = y;
		top.x2 =  top.x1 + width;
		top.y2 = top.y1;
		
		down.x1 =  x;
		down.y1 =  y + height;
		down.x2 = down.x1 + width;
		down.y2 = down.y1;
		
		right.x1 = x + width;
		right.y1 = y;
		right.x2 = right.x1;
		right.y2 = right.y1 + height;
		
		left.x1 = x;
		left.y1 = y;
		left.y2 = left.y1 + height;
		left.x2 = left.x1;
		
		
	}
	
	public static boolean intersects(CollisionBox entityBox,CollisionBox tileBox){
		Rectangle rec1, rec2;		
		rec1=new Rectangle(entityBox.boundsX, entityBox.boundsY, entityBox.width, entityBox.height);
		rec2=new Rectangle(tileBox.boundsX, tileBox.boundsY, tileBox.width, tileBox.height);
		return (rec1.intersects(rec2));
	}
	
	public static boolean intersects(CollisionBox entityBox,CollisionBox tileBox,int boundsXadvance,int boundsYadvance){
		Rectangle rec1, rec2;		
		rec1=new Rectangle(entityBox.boundsX+boundsXadvance, (entityBox.boundsY+boundsYadvance), entityBox.width, entityBox.height);
		rec2=new Rectangle(tileBox.boundsX, tileBox.boundsY, tileBox.width, tileBox.height);
		//System.out.println("Y: "+(entityBox.boundsY+boundsYadvance));
		return (rec1.intersects(rec2));
	}
	
	public Line getTop() {
		return top;
	}

	public void setTop(Line top) {
		this.top = top;
	}

	public Line getLeft() {
		return left;
	}

	public void setLeft(Line left) {
		this.left = left;
	}

	public Line getRight() {
		return right;
	}

	public void setRight(Line right) {
		this.right = right;
	}

	public Line getDown() {
		return down;
	}

	public void setDown(Line down) {
		this.down = down;
	}

		
	

}
