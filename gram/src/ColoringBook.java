import java.util.*;

class PairCB{
	int x,y;

	public PairCB(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class ColoringBook {
	
	public static int[] nx= {0,1,0,-1};
	public static int[] ny= {1,0,-1,0};
	public static Queue<PairCB> q = new LinkedList<>();
	public static boolean visited[][] ;
	public static int M;
	public static int N;
	public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited=new boolean[m][n];
        M=m;
        N=n;
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        for(int i =0;i<m;i++) {
        	for(int j=0;j<n;j++) {
        		if(!visited[i][j]&&picture[i][j]!=0) {
        			q.offer(new PairCB(i,j));
        			visited[i][j]=true;
        			answer[0]++;
        			int x = bfs(picture);
        			if(x>answer[1]) {
        				answer[1]=x;
        			}
        		}
        	}
        }
        return answer;
    }
	public static int bfs(int[][] arr) {
		int cnt=0;
		while(!q.isEmpty()) {
			PairCB p = q.poll();
			int x =p.x;
			int y= p.y;
			cnt++;
			for(int i =0;i<nx.length;i++) {
				int dx=x+nx[i];
				int dy=y+ny[i];
				if(isPossible(dx,dy)&&arr[dx][dy]==arr[x][y]) {
					q.offer(new PairCB(dx,dy));
					visited[dx][dy]=true;
				}
			}
		}
		return cnt;
	}
	public static boolean isPossible(int x, int y) {
		if(x<0||x>=M||y<0||y>=N)
			return false;
		if(visited[x][y])
			return false;
		return true;
	}
	public static void main(String[] args) {
		
		solution(6,4,new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
	}

}
