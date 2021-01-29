import java.util.*;
import java.io.*;
public class Baek10815 {
	public static int stoi(String X ) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = stoi(br.readLine());
		HashMap<Integer,Integer> hsmap = new HashMap<>();
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			int X = stoi(st.nextToken());
			hsmap.put(X,1);
		}
		int M = stoi(br.readLine());
		st= new StringTokenizer(br.readLine());
		for(int i =0;i<M;i++) {
			int X = stoi(st.nextToken());
			if(hsmap.get(X)==null)
				System.out.print("0 ");
			else
			System.out.print(hsmap.get(X)+" ");
		}
		
	}

}
