package jvvv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek1292 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum=0;
		int num1 = 0;
		int num2 = 0;
		
		ArrayList<Integer> arr =new ArrayList<>();
		for(int i =1;i<=1000;i++){
			for(int j =1;j<=i;j++){
				arr.add(i);
			}
		}
		
		
		while(st.hasMoreTokens()){
			 num1=Integer.parseInt(st.nextToken());
			 num2 =Integer.parseInt(st.nextToken());
		}
		for(int i = num1-1;i<=num2-1;i++){
			sum+=arr.get(i);
		}
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
		br.close();
		

	}

}
