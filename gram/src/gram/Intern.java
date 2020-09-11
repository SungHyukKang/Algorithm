package gram;

import java.util.Scanner;

public class Intern {
	
	
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int team = 0;
		
		while(N>=2&&M>=1&&N+M>=3+K){
			N=N-2;
			M--;
			team++;
		}
		
		System.out.println(team);
	}
}
