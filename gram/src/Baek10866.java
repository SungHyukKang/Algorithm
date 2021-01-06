import java.util.*;
import java.io.*;
public class Baek10866 {
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> dq = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		for(int i =0;i<N;i++) {
			String X = br.readLine();
			int z;
			if(X.startsWith("push_front")) {
				z=Integer.parseInt(X.split(" ")[1]);
				dq.addFirst(z);
			}else if(X.startsWith("push_back")) {
				z=Integer.parseInt(X.split(" ")[1]);
				dq.addLast(z);
			}else if(X.startsWith("pop_front")) {
				if(dq.isEmpty()) {
					System.out.println("-1");
					continue;
				}
				System.out.println(dq.pollFirst());
			}else if(X.startsWith("pop_back")) {
				if(dq.isEmpty()) {
					System.out.println("-1");
					continue;
				}
				System.out.println(dq.pollLast());
			}else if(X.startsWith("size")) {
				System.out.println(dq.size());
			}else if(X.startsWith("empty")) {
				if(dq.isEmpty()) {
					System.out.println("1");
				}else
					System.out.println("0");
			}else if(X.startsWith("front")) {
				if(dq.isEmpty()) {
					System.out.println("-1");
					continue;
				}
				System.out.println(dq.peekFirst());
			}else {
				if(dq.isEmpty()) {
					System.out.println("-1");
					continue;
				}
				System.out.println(dq.peekLast());
			}
		}
		
		
		
	}

}
