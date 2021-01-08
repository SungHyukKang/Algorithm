import java.util.*;
import java.io.*;

public class Baek2485 {

	public static int gcd(int x, int y) {
		if (y % x == 0)
			return x;
		return gcd(y, x % y);
	}

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		for(int i =0;i<N;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(list);
		
		for(int i =1;i<N;i++) {
			list2.add(list.get(i)-list.get(i-1)); 		
		}
		int x =0;
		for(int i=1;i<list2.size();i++) {
			if(x==0)
				x = gcd(list2.get(i), list2.get(i - 1));
			else
				x = gcd(Math.max(x, list2.get(i)), Math.min(x, list2.get(i)));
		}
		int c = list.get(list.size()-1)-list.get(0);
		System.out.println(c/x-(N-1));
		
	}

}
