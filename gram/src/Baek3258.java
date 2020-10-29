import java.util.*;
import java.io.*;
public class Baek3258 {
	public static int stoi(String X ) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N =stoi(st.nextToken());
		int Z =stoi(st.nextToken());
		int M =stoi(st.nextToken());
		st = new StringTokenizer(br.readLine());
		HashMap<Integer,Boolean> hsmap2=new HashMap<>();
		for(int i =0;i<M;i++) {
			hsmap2.put(stoi(st.nextToken()),false);
		}
		
		
		for(int i=1;i<1001;i++) {
			HashMap<Integer,Integer> hsmap =new HashMap<>();
			for(int k=1;k<=N;k++) {
				hsmap.put(k,0);
			}
			int j=1;
			while(true) {
				hsmap2.put(j,hsmap2.getOrDefault(j, true));
				if(j>N) {
					j=j-N;
				}
				if(!hsmap2.get(j)) {
					break;
				}
				if(hsmap.get(j)>=2) {
					break;
				}
				if(j==Z) {
					System.out.println(i);
					System.exit(0);
				}
				hsmap.put(j,hsmap.getOrDefault(j, 0)+1);
				j+=i;
			}
		}
	}

}
