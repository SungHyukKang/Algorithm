import java.util.*;
import java.io.*;
public class Baek1700 {
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N =Integer.parseInt(st.nextToken());
		int K =Integer.parseInt(st.nextToken());
		HashMap<Integer,Boolean> hsmap =new HashMap<>();
		for(int i =1;i<1000;i++) {
			hsmap.put(i,false);
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			hsmap.put(Integer.parseInt(st.nextToken()),true);
		}
		int ans=0;
		for(int i =0;i<K-N;i++) {
			if(!hsmap.get(Integer.parseInt(st.nextToken()))) {
				
			}
		}
	}	

}
