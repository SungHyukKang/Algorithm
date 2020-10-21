import java.util.*;
import java.io.*;
public class Baek2437 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		StringTokenizer st =new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		int answer=1;
		for(int x : list) {
			if(answer<x) {
				break;
			}
			answer+=x;
		}
		System.out.println(answer);
	}
}
