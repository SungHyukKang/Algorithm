import java.util.*;
import java.io.*;

class Pair15686{
	int x,y;
	
	Pair15686(int x, int y){
		this.x=x;
		this.y=y;
	}
}

public class Baek15686 {
	static int min=2100000000;
	static boolean[][] visited;
	static int[][] arr;
	static int N;
	static int M;
	static Stack<Pair15686> stack = new Stack<>();
	static ArrayList<Pair15686> list = new ArrayList<>();
	static ArrayList<Pair15686> houses = new ArrayList<>();
	static ArrayList<Pair15686> dis = new ArrayList<>();
	static HashMap<Integer,Integer> hsmap = new HashMap<>();
	public static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = stoi(st.nextToken());
		arr=new int[N][N];
		visited = new boolean[N][N];
		M = stoi(st.nextToken());
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=stoi(st.nextToken());
				if(arr[i][j]==2) {
					arr[i][j]=0;
					list.add(new Pair15686(i,j));
				}
				if(arr[i][j]==1) {
					houses.add(new Pair15686(i,j));
				}
			}
		}
		dfs(0,0);
		System.out.println(min);
	}
	
	static void dfs(int start,int cnt) {
		int sum=0;
		hsmap=new HashMap<>();
		if(M==cnt) {
			for(int i=0;i<stack.size();i++) {
				int x= stack.get(i).x;
				int y= stack.get(i).y;
				for(int j =0;j<houses.size();j++) {
					int xx = Math.abs(houses.get(j).x-x);
					int yy = Math.abs(houses.get(j).y-y);
					if(hsmap.get(j)==null) {
						hsmap.put(j,xx+yy);
					}else {
						if(hsmap.get(j)>xx+yy) {
							hsmap.put(j,xx+yy);
						}
					}
				}
			}
			for(Integer zz :hsmap.values()) {
				sum+=zz;
			}
			if(min>sum)
				min=sum;
			return;
		}
		for(int i =start;i<list.size();i++) {
			int x = list.get(i).x;
			int y = list.get(i).y;
			if(!visited[x][y]) {
			visited[x][y]=true;
			stack.push(new Pair15686(x,y));
			cnt++;
			dfs(i,cnt);
			cnt--;
			stack.pop();
			visited[x][y]=false;
			}
		}
		
	}
	
}
