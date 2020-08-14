package jvvv;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Baek6603 {
	 static void print(int[] arr, boolean[] visited, int n) {
	        for (int i = 0; i < n; i++) {
	            if (visited[i]) {
	                System.out.print(arr[i] + " ");
	            }
	        }
	        System.out.println();
	    }
	 
	static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
	    if(r == 0) {
	        print(arr, visited, n);
	        return;
	    } 

	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        combination(arr, visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr ;
		boolean[] visited ;
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if(N==0)
				return;
			arr=new int[N];
			visited=new boolean[N];
			for(int i =0;i<N;i++){
				arr[i]=Integer.parseInt(st.nextToken());
			}
			combination(arr,visited,0,N,6);
			System.out.println();
		}
	}

}
