package net.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyList implements KeyListener {
	
	
	public static boolean[] keys = new boolean [600];
	public static int getInput() {
			 if(keys[KeyEvent.VK_UP]) 	{return 0;}
		else if(keys[KeyEvent.VK_RIGHT]){return 1;}
		else if(keys[KeyEvent.VK_DOWN])	{return 2;}
		else if(keys[KeyEvent.VK_LEFT])	{return 3;}
		return -1;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
