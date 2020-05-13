package gram;

import java.util.*;

public class Solution4 {
	public static long[] solution(long x , int n){
		long[] answer=new long[n];
		long z =x;
		ArrayList<Long> list = new ArrayList<Long>();
		list.add(x);
		for (int i = 0 ;i<n;i++){
			z=z+x;
			list.add(z);
		}
		int count = 0;
		for(long b : list){
			if(count+1==list.size())
				break;
			answer[count++]=b;
		}
		return answer;
	}
	public static void main(String[] args) {
		for(int i = 0 ;i<9;i++)
		System.out.println(Solution4.solution(3, 9)[i]);
	}

}
