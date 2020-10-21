import java.util.*;
import java.io.*;
public class Baek14888 {
	static int N;
	static Stack<String> stack  =new Stack<>();
	static int[] ope;
	static int[] arr;
	static String[] operand= {"+","-","*","/"};
	static int max = -2100000000;
	static int min =2100000000;
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		st=new StringTokenizer(br.readLine());
		ope =new int[4];
		int plus=Integer.parseInt(st.nextToken());
		int minus=Integer.parseInt(st.nextToken());
		int mul=Integer.parseInt(st.nextToken());
		int div=Integer.parseInt(st.nextToken());
		for(int i =0;i<4;i++) {
			ope[0]=plus;
			ope[1]=minus;
			ope[2]=mul;
			ope[3]=div;
			stack = new Stack<>();
			if(ope[i]>0) {
			stack.push(operand[i]);
			ope[i]--;
			dfs();
			}
		}
		System.out.println(max);
		System.out.println(min);
		
	}
	
	static void dfs() {
		if(stack.size()==N-1) {
			int sum = arr[0];
			for(int i =0;i<stack.size();i++) {
				if(stack.get(i).equals("+")) {
					sum+=arr[i+1];
				}else if(stack.get(i).equals("-")) {
					sum-=arr[i+1];
				}else if(stack.get(i).equals("*")) {
					sum*=arr[i+1];
				}else {
					sum/=arr[i+1];
				}
			}
			if(sum>max)
				max=sum;
			if(sum<min) {
				min=sum;
			}
			return;
		}
		for(int i =0;i<4;i++) {
			if(ope[i]>0) {
				stack.push(operand[i]);
				ope[i]--;
				dfs();
				ope[i]++;
				stack.pop();
			}
		}
	}
	
}
