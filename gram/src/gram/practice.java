package gram;

import java.util.Scanner;

public class practice {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[][] A = new int[20][20];
		int n = sc.nextInt();
		int x ;
		int y;
		for(int i = 0 ;i<n;i++){
			x=sc.nextInt();
			y=sc.nextInt();
			A[x][y]=1;
		}
		for(int i =0;i<20;i++){
			for(int j = 0 ;j<20;j++){
				System.out.print(A[i][j]);
			}
			System.out.println();
		}
		
	}

}
