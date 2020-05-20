package net.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Main implements KeyListener{
	
	//a 2048 game:
	/*needed
		render functionality
		array with boxes
		moving + combining
		
	*/
	private static int score;
	private static int map[];
	private static Random R;
	private static int tileGenMax=2;
	public static boolean legal[]= new boolean[4];
	
	public static void init(int mapSize) {
		score=0;
		map = new int[mapSize*mapSize];
		for(int i = 0; i < map.length; i++) {
			map[i]=0;
		}
		newTile();
		newTile();
	}
	
	
	
	
	private static void newTile() {
		boolean foundPos=true;
		while(foundPos) {
			int i = R.nextInt(map.length);
			int value = (R.nextInt(tileGenMax)+1)*2;
			if(map[i]==0) {
				map[i]= value;
				foundPos=false;
			}
		}
	}
	
	
	public static boolean getLegal(){
		
		return false;
	}
	
	
	public static void main(String args[]) {
		R=new Random();
		init(4);
		printMap();
		//main loop:
			if(getLegal()) {
				getInput();
				//add score
			}else {
				//lose		
			}
	
	}
	
	
	
	




	private static void printMap() {
		int w = (int)Math.sqrt((map.length+1));
		System.out.println("------------------");
		for(int x = 0; x < w; x++) {
			System.out.print("|");
			for(int y = 0; y < w; y++) {
				System.out.print(
						String.format(
								"%4s",map[x+y*w]		
						));
			}
			System.out.println("|");
			System.out.println("|                |");
		}
		System.out.println("------------------");
	}



	
	
	public static boolean[] keys = new boolean [600];
	private static void getInput() {
		legal[0] = keys[KeyEvent.VK_UP];
		legal[1] = keys[KeyEvent.VK_RIGHT];
		legal[2] = keys[KeyEvent.VK_DOWN];
		legal[3] = keys[KeyEvent.VK_LEFT];
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
