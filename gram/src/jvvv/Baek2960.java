package jvvv;
import java.util.Scanner;

public class Baek2960 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N+1];
        int cnt =0;
        
        for(int i=2;i<=N;i++) {
        	for(int j =1;j<=N/2;j++) {
        		if(i*j<=N) {
        			if(arr[i*j]==-1)
        				continue;
        			arr[i*j]=-1;
        			cnt++;
        			if(cnt==M) {
        				System.out.println(i*j);
        				return;
        			}
        		}
        	}
        }
        
    }
}
