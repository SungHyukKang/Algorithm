package Greedy;
import java.util.*;
public class ATM {
	public static void main(String[] args) {
		
		
		Scanner sc =new Scanner(System.in);
		int x = sc.nextInt();
		sc.nextLine();
		int[] P =new int[x];
		for(int i = 0 ;i<x;i++)
			P[i]=sc.nextInt();
		sc.close();
		
		int[] answer=new int[P.length];
		Arrays.sort(P);
		
		int sum = 0 ;
		int sum2=0;
		for(int i = 0 ;i<P.length;i++){
			if(i==0){
				answer[0]=P[i];
				sum=answer[0];
			}else{
				sum+=P[i];
				answer[i]=sum+answer[i];
			}
			sum2+=answer[i];
		}
		if(x<=1){
			System.out.println(sum);
		}else
			System.out.println(sum2);
	}

}
