import java.util.*;
import java.io.*;
public class Baek1744 {
	
	static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> list = new PriorityQueue<>(Collections.reverseOrder());
		LinkedList<Integer> qplus = new LinkedList<>();
		LinkedList<Integer> qminus   = new LinkedList<>();
		
		int N =stoi(br.readLine());
		for(int i =0;i<N;i++) {
			list.add(stoi(br.readLine()));
		}
		HashMap<Integer,Integer> hsmap = new HashMap<>();
		
		while(!list.isEmpty()) {
			int num =list.poll();
			if(num>=0) {
				qplus.add(num);
			}else
				qminus.add(num);
		}
		Collections.reverse(qminus);
		int sum=0;
		ArrayList<Integer> lastpang = new ArrayList<>();
		while(!qplus.isEmpty()) {
			int num= qplus.pollFirst();
			if(!qplus.isEmpty()) {
				int num2=qplus.pollFirst();
				sum+=Math.max(num*num2,num+num2);
				continue;
			}
			lastpang.add(num);
		}
		while(!qminus.isEmpty()) {
			int num= qminus.pollFirst();
			if(!qminus.isEmpty()) {
				int num2=qminus.pollFirst();
				sum+=Math.max(num*num2,num+num2);
				continue;
			}
			lastpang.add(num);
		}
		if(lastpang.size()<1) {
			System.out.println(sum);
			return;
		}
		else if(lastpang.size()==1){
			sum+=lastpang.get(0);
		}else
			sum+=Math.max(lastpang.get(0)+lastpang.get(1),lastpang.get(0)*lastpang.get(1));
		System.out.println(sum);
	}

}
