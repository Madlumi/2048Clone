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
		
		int w = (int)Math.sqrt((map.length+1));
		legal[0]=false;
		legal[1]=false;
		legal[2]=false;
		legal[3]=false;
		
		for(int x = 0; x < w; x++) {
			for(int y = 0; y < w; y++) {
				if(y>1)		if(map[x+(y-1)*w]==0||map[x+(y-1)*w]==map[x+y*w])legal[0]=true;
				if(y<w-1)	if(map[x+(y+1)*w]==0||map[x+(y-1)*w]==map[x+y*w])legal[0]=true;
			}
		}
		
		
		return false;
	}
	
	
	public static void main(String args[]) {
		R=new Random();
		//initialize map
		init(4);
		//print the map
		printMap();
		//main loop:
			if(getLegal()) {
				int inkey=-1;
				while(inkey==-1){
					inkey=KeyList.getInput();
					if(!legal[inkey])inkey=-1;
				}
				//move	
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



	
	
	
	
}
