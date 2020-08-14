package jvvv;

import java.util.Scanner;
import java.util.Stack;

public class StackSequ {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr =new int[N];
		Stack<Integer> stack = new Stack<>();
		Stack<String> stackS = new Stack<>();
		for(int i =0;i<N;i++){
			arr[i]=sc.nextInt();
		}
		stack.push(1);
		stackS.push("+");
		int S =1;
		int cnt=0;
		while(cnt<N){
			if((!stack.isEmpty())&&(stack.lastElement()==arr[cnt])){
				stack.pop();
				cnt++;
				stackS.push("-");
				continue;
			}
			stack.push(++S);
			if(S>N*1000){
				System.out.println("NO");
				return;
			}
			stackS.push("+");
		}
		for(String Z : stackS){
			System.out.println(Z);
		}
	}
}
