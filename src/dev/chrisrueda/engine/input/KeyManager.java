package dev.chrisrueda.engine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;




public class KeyManager implements KeyListener {
	
	//this is singleton pattern, to make sure only one instance of this class is created 
	private static KeyManager keyManager = new KeyManager(); //instance was created upon class load
	
	
	private boolean[] keys = new boolean[256];

	private KeyManager(){ //constructor was set to private to implement singleton pattern
		
	}
	
	public static KeyManager getInstance()
	{
		return keyManager;
	}
	
	public boolean isKeyDown( int key )
	{
		int keyId = key & 255;
		return keys[keyId];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyId = (e.getKeyCode() & 255);
		keys[keyId]=true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyId = (e.getKeyCode() & 255);
		keys[keyId]=false;		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



}
