package dev.chrisrueda.engine.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.chrisrueda.engine.gfx.GameCamera;

public class StaticEntity extends Entity {
	BufferedImage img;

	public StaticEntity(BufferedImage img, int x, int y, int width, int height) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.width = width;
		this.height = height;
		this.img = img;
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		int xOffSet = (int) GameCamera.xOffset;
		int yOffSet = (int) GameCamera.yOffset;
		
		g.drawImage(img, x - xOffSet, y - yOffSet, null);
		
	}

}
