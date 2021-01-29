import java.util.*;
import java.io.*;
public class Baek1745 {
	
	static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		int N =stoi(br.readLine());
		for(int i =0;i<N;i++) {
			list.add(stoi(br.readLine()));
		}
		Collections.sort(list,new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg0<=arg1 ? 1 : -1;
			}
		});
		System.out.println(list);
	}

}
