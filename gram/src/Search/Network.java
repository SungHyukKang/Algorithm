package Search;
public class Network {
	public static int size;
	public static boolean[] visited;
	public static int count =0 ;
	public static void dfs(int[][] arr,int start) {
		for(int i =0;i<size;i++) {
			if(arr[start][i]==1&&!visited[i]&&i!=start) {
				visited[i]=true;
				dfs(arr,i);
			}
		}
	}
	 
	public int solution(int n , int[][] computers){
		size = n;
		visited=new boolean[n];
		for(int i =0;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(computers,i);
				count++;
			}
		}
		System.out.println(count);
		return count;
	}
	
	public static void main(String[] args) {
			
		Network n = new Network();
		n.solution(4, new int[][]{{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}});

	}

}
