import java.util.*;
import java.io.*;

public class Baek1052 {	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X =2;
		int i =0;
		if(N==K) {
			System.out.println("0");
			return;
		}
		ArrayList<Integer> list = new ArrayList<>();
		while(N>0) {
			i++;
			X=(int)Math.pow(2,i);
			if(X>=N) {
				X=(int)Math.pow(2,i-1);
				list.add(X);
				N-=X;
				i=0;
			}
		}
		Collections.sort(list);
		if(list.size()<=K) {
			System.out.println("0");
			return;
		}
		int sum=0;
		for(int z =0;z<list.size()-K;z++) {
			sum+=list.get(z);
		}
		System.out.println(list.get(list.size()-K)-sum);
	}
}
