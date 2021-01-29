package LINE;
import java.util.*;
class Pair {
	int x,y,d;
	Pair(int x, int y){
		this.x=x;
		this.y=y;
	}
}

public class Problem4 {
	static Queue<Pair> q = new LinkedList<>();
	static int[] nx = {-1,0,1,0};
	static int[] ny = {0,1,0,-1};
	static int[] nx2 = {1,0,-1,0};
	static int[] ny2 = {0,1,0,-1};
	
	
	
	static int[][] arr ;
	static boolean[][] visited;
	public int solution(int[][] maze) {
        int answer = 0;
        visited = new boolean[maze.length][maze[0].length];
        arr= new int[maze.length][maze[0].length];
        for(int i =0;i<maze.length;i++) {
        	for(int j = 0;j<maze.length;j++) {
        		if(maze[i][j]==1) {
        			arr[i][j]=-1;
        		}else
        		arr[i][j]=maze[i][j];
        	}
        }
        q.offer(new Pair(0,0));
        visited[0][0]=true;
        if(arr[0][1]==-1) {
        	bfs();
        }else {
        	bfs2();
        }
        print();
        return answer;
    }
	public static void bfs() {
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			int x = pair.x;
			int y = pair.y;
			if(x==arr.length-1&&y==arr.length-1) {
				break;
			}
			for(int i =0;i<nx.length;i++) {
				if(isPossible(x+nx[i],y+ny[i])&&!visited[x+nx[i]][y+ny[i]]) {
					arr[x+nx[i]][y+ny[i]]=arr[x][y]+1;
					q.offer(new Pair(x+nx[i],y+ny[i]));
					visited[x+nx[i]][y+ny[i]]=true;
					break;
				}
			}
			if(q.isEmpty()) {
				visited = new boolean[arr.length][arr.length];
				q.offer(new Pair(x,y));
				visited[x][y]=true;
			}
			print();
//			visited = new boolean[arr.length][arr.length];
//			q.offer(new Pair(x,y));
		}
	}
	
	public static void bfs2() {
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			int x = pair.x;
			int y = pair.y;
			if(x==arr.length-1&&y==arr.length-1) {
				break;
			}
			visited[x][y]=true;
			for(int i =0;i<nx2.length;i++) {
				if(isPossible(x+nx2[i],y+ny2[i])&&!visited[x+nx2[i]][y+ny2[i]]) {
					arr[x+nx2[i]][y+ny2[i]]=arr[x][y]+1;
					q.offer(new Pair(x+nx2[i],y+ny2[i]));
					visited[x+nx2[i]][y+ny2[i]]=true;
					break;
				}
			}
			if(q.isEmpty()) {
				visited = new boolean[arr.length][arr.length];
				q.offer(new Pair(x,y));
				visited[x][y]=true;
			}
			print();
//			visited = new boolean[arr.length][arr.length];
//			q.offer(new Pair(x,y));
		}
	}
	
	public static boolean isPossible2(int x, int y) {
		if(x<0||x>=arr.length||y<0||y>=arr[0].length) {
			return false;
		}
		return true;
	}
	
	public static boolean isPossible(int x, int y) {
		if(x<0||x>=arr.length||y<0||y>=arr[0].length) {
			return false;
		}
		if(arr[x][y]==-1) {
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Problem4 pb = new Problem4();
//		pb.solution(new int[][] {{0, 1, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}});
//		pb.solution(new int[][] {{0, 1, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 1, 0}, {0, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 0}});
//		pb.solution(new int[][] {{0, 1, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}, {1, 0, 1, 0}});
//		pb.solution(new int[][] {{0, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}, {1, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}, {1, 1, 0, 1, 1, 0}});
	}
	static int turnLeft(int d) {
		if(d==0) {
			return 3;
		}else if(d == 1) {
			return 0;
		}else if(d==2) {
			return 1;
		}else
			return 2;	
	}
	
	static void print() {
		for(int i=0;i<arr.length;i++) {
			for(int j =0;j<arr[i].length;j++) {
				if(arr[i][j]==-1) {
					System.out.print("1 ");
				}else
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-------------------------");
	}
	
}
