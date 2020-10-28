import java.util.*;
import java.io.*;

class Robot{
	int x,y,dir;
	
	Robot(int x, int y,int dir){
		this.x=x;
		this.y=y;
		this.dir=dir;
	}
}

public class Baek2174 {
	static int A;
	static int B;
	static int N;
	static int M;
	static int[][] arr;
	static Robot[] robot;
	static int[] nx= {0,1,0,-1};
	static int[] ny= {1,0,-1,0};
	static int stoi(String X) {return Integer.parseInt(X);}
    public static void main(String[] args)throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A=stoi(st.nextToken());
        B=stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        N=stoi(st.nextToken());
        M=stoi(st.nextToken());
        arr=new int[A+1][B+1];
        
        robot = new Robot[N+1];
        for(int i =1;i<=N;i++) {
        	st=new StringTokenizer(br.readLine());
        	int x = stoi(st.nextToken());
        	int y= stoi(st.nextToken());
        	int dir =direction(st.nextToken());
        	robot[i]=new Robot(x,y,dir);
        	arr[x][y]=i;
        }
        for(int i =0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	int x = stoi(st.nextToken());
        	String word = st.nextToken();
        	int go= stoi(st.nextToken());
        	move(x,word,go);
        }
        System.out.println("OK");
        
    }
    static void move(int idx,String cmd ,int go) {
    	if(cmd.equals("F")) {
    		for(int i =0;i<go;i++) {
    			int mx=robot[idx].x+nx[robot[idx].dir];
    			int my=robot[idx].y+ny[robot[idx].dir];
    			if(isPossible(mx ,my)) {
    				if(arr[mx][my]!=0) {
    					System.out.println("Robot "+idx+" crashes into robot "+arr[mx][my]);
    					System.exit(0);
    				}
    				arr[robot[idx].x][robot[idx].y]=0;
    				robot[idx].x=mx;
    				robot[idx].y=my;
    				arr[mx][my]=idx;
    			}else {
    				System.out.println("Robot "+idx+" crashes into the wall");
    				System.exit(0);
    			}
    		}
    	}else if(cmd.equals("L")) {
    		int X = go%4;
    		for(int i=0;i<X;i++) {
    		int dir = turnL(robot[idx].dir);
    		robot[idx].dir=dir;
    		}
		}else {
			int X = go%4;
    		for(int i=0;i<X;i++) {
    			int dir = turnR(robot[idx].dir);
    			robot[idx].dir=dir;
    		}
		}
	}
    //R D L U
    static int turnL(int dir) {
    	if(dir == 0) {
    		return 3;
    	}else if(dir==1) {
    		return 0;
    	}else if(dir==2) {
    		return 1;
    	}else {
    		return 2;
    	}
    }
    static int turnR(int dir) {
    	if(dir==0){
    		return 1;
    	}else if(dir==1) {
    		return 2;
    	}else if(dir==2) {
    		return 3;
    	}else
    		return 0;
    }
    static boolean isPossible(int x, int y) {
    	if(x<1||x>A||y<1||y>B) {
    		return false;
    	}
    	return true;
    }
    
    static int direction(String X) {
    	if(X.equals("E")) {
    		return 1;
    	}else if(X.equals("N"))
    		return 0;
    	else if(X.equals("W")) {
    		return 3;
    	}else
    		return 2;
    }
}
