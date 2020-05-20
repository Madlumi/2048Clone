package net.game;

import java.util.Random;

public class Main {
	
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
	
	
	public static void main(String args[]) {
		System.out.println("hello world");
		R=new Random();
		init(4);
		printMap();
		System.out.println("hello world");
		//set score 0
		//generate tile 1 and 2
		//main loop:
		//	check legal moves:
		//		allow move
		//		lose
		//	move,combine
		//	add score
	}
}
