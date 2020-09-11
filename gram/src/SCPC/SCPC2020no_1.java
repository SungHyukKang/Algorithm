package SCPC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SCPC2020no_1 {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int T =sc.nextInt();
			for(int t=0;t<T;t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			ArrayList<Integer> A = new ArrayList<>();
			ArrayList<Integer> B = new ArrayList<>();
			for(int i =0;i<N;i++) {
				int num = sc.nextInt();
				A.add(num);
			}
			
			for(int i =0;i<N;i++) {
				int num = sc.nextInt();
				B.add(num);
			}
			
			Collections.sort(A);
			Collections.sort(B);
			int max = 0;
			for(int i =0;i<K;i++) {
				int sum = A.get(i)+B.get(K-i-1);
				if(max<sum) {
					max=sum;
				}
			}
			System.out.println("Case #"+(t+1));
			System.out.println(max);
	}
	}
}
