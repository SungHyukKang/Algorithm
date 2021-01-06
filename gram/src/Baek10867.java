import java.util.*;
import java.io.*;
public class Baek10867 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0;i<x;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		LinkedHashSet<Integer> hsset = new LinkedHashSet<>();
		for(int c : list) {
				hsset.add(c);
			}
		
		for(int cc : hsset) {
			System.out.print(cc+" ");
		}
		}
	
		
	}


