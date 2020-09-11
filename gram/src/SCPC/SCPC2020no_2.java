package SCPC;

import java.util.Scanner;

public class SCPC2020no_2 {
	public static int n;
	public static int k;
	public static int cntA=0;
	public static int cntB=0;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t= 0;t<T;t++) {
			n=sc.nextInt();
			cntA=n;
			cntB=n;
			k=sc.nextInt();
			arr=new int[2][n+1];
			visited=new boolean[2][n+1];
			for(int i =0;i<2;i++) {
				for(int j=1;j<=n;j++) {
					int num = sc.nextInt();
					arr[i][j]=num;
				}
			}
			for(int i =0;i<2;i++) {
				
				dfs(i,k);
				System.out.println("cnt!!!"+cnt);
			}
			System.out.println("Case #"+(t+1));
		}
	}
	public static void dfs(int x ,int sum) {
		if(cntA+cntB==0) {
			cntA=n;
			cntB=n;
			cnt++;
			return;
		}
		System.out.println("!");
			for(int i =0;i<2;i++) {
				for(int j=n;j>=1;j--) {
					if(sum-arr[x][j]>=0&&!visited[x][j]) {
						if(x==0) {
							cntA--;
						}else {
							cntB--;
							}
						
						System.out.println(x+" "+j);
						visited[x][j]=true;
						sum=sum-arr[x][j];
						if(sum==0) {
							sum=k;
						}
						dfs(i,sum);
						
					}
				}
			}
		}
	}

