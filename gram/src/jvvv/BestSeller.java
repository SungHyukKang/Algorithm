	package jvvv;
	
	import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
	import java.util.Scanner;

	public class BestSeller {
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			HashMap<String,Integer> hsmap = new HashMap<>();
			
			for(int i = 0 ;i<N;i++){
				String X =sc.next();
				hsmap.put(X, hsmap.getOrDefault(X, 0)+1);
			}
			int value=0;
			int max= -1;
			String answer ="";
			ArrayList<String> keys = new ArrayList<>();
			for(String key : hsmap.keySet()){
				keys.add(key);

			}
			Collections.sort(keys);
			
			for(String key : keys){
				value=hsmap.get(key);
				if(max==value){
					continue;
				}
				if(max<value){
					answer=key;
					max=value;
				}
			}
			System.out.println(answer);
		}
		
	}
