package Brandi;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


public class No_1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[6];
		StringTokenizer st = new StringTokenizer(br.readLine());
		double age = Double.parseDouble(st.nextToken());
		double maximum = 220-age;
		String input ="";
		String S ;
		while((S = sc.nextLine())!=null) {
			int X=Integer.parseInt(S);
			if(X>=maximum*0.9) {
				arr[0]++;
			}else if(X>=maximum*0.8) {
				arr[1]++;
			}else if(X>=maximum*0.75) {
				arr[2]++;
			}else if(X>=maximum*0.68) {
				arr[3]++;
			}else if(X>=maximum*0.6) {
				arr[4]++;
			}else {
				arr[5]++;
			}
		}
		
	}

}
