package second;

import java.util.*;
class Pair{
	int x,y;
	
	Pair(int x,int y){
		this.x=x;
		this.y=y;
	}
}
public class Problem3 {
	static final int INF =9999999;
	static boolean[] visited;
	static int max=0;
	static int fir=-1;
	static int sta=0;
	static Pair pair=null;
	static ArrayList<Integer> te=new ArrayList<>();
	static HashMap<Integer,Integer> hsmap =new HashMap<>();
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	public static int solution(int n, int[][] edges) {
        int answer = 0;
        visited= new boolean[n+1];
        for(int i =0;i<=n;i++) {
        	list.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++) {
        	list.get(edges[i][0]).add(edges[i][1]);
        	list.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i =1;i<=n;i++) {
        	visited=new boolean[n+1];
        	visited[i]=true;
        	sta=i;
        	dfs(i,0);
        }
        System.out.println(max);
        max=0;
        for(int i =1;i<=n;i++) {
        	visited=new boolean[n+1];
        	visited[i]=true;
        	visited[pair.x]=true;
            visited[pair.y]=true;
        	dfs2(i,0);
        }
        System.out.println(max);
        
        System.out.println(pair.x+" "+pair.y);
        System.out.println(max);
        return answer/3;
    }
	
	public static void dfs2(int start,int sum) {
		if(max<sum) {
			max=sum;
		}
		for(int x : list.get(start)) {
			if(!visited[x]) {
				visited[x]=true;
				dfs2(x,sum+1);
			}
		}
	}
	
	public static void dfs(int start,int sum) {
		if(max<sum) {
			max=sum;
			fir=start;
			pair=new Pair(sta,fir);
		}
		for(int x : list.get(start)) {
			if(!visited[x]) {
				visited[x]=true;
				dfs(x,sum+1);
			}
		}
	}
	public static void main(String[] args) {
		solution(4,new int[][] {{1,2},{2,3},{3,4}});
	}

}
