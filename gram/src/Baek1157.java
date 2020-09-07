import java.util.*;
import java.io.*;
public class Baek1157 {

	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,Integer> hsmap = new HashMap<>();
		ArrayList<String> arr =new ArrayList<>();
		String word = br.readLine().toUpperCase();
		String[] wordArr =word.split("");
		for(String Z : wordArr) {
			hsmap.put(Z,hsmap.getOrDefault(Z,0)+1);
		}
		int num=-1;
		for(int X : hsmap.values()) {
			if(num<X) {
				num=X;
			}
		}
		for(String ZZ : hsmap.keySet()) {
			if(hsmap.get(ZZ)==num) {
				arr.add(ZZ);
			}
		}
		if(arr.size()>1) {
			System.out.println("?");
		}else
			System.out.println(arr.get(0));
	}

}
