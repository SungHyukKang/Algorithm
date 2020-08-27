package Search;

import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		ArrayList<String> arr =new ArrayList<>();
		int i  =0;
		String temp;
		for(String X : input.split(" ")) {
			if(!arr.contains(X))
				arr.add(X);
			else {
				i=arr.indexOf("X");
				
			}
			System.out.println(arr);
		}
		
	}
}