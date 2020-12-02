import java.util.*;
import java.io.*;
public class Baek1417 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n==1) {
			System.out.println("0");
			return;
		}
		int me =0;
		me=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int max= 0;
		for(int  i=1;i<n;i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		max=pq.peek();
		int cnt=0;
		while(max>=me) {
			int x = pq.poll();
			me++;
			cnt++;
			x--;
			pq.offer(x);
			max=pq.peek();
		}
		System.out.println(cnt);
	}

}
