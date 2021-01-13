package Sort;

import java.util.*;
public class Hindex {
	public static int solution(int[] citations) {
		int answer = 0;
		if(citations.length==1)
			return citations[0];
		ArrayList<Integer> list = new ArrayList<>();
		for(int x : citations) {
			list.add(x);
		}
		Collections.sort(list,(x,y)->{
			return x>=y?-1:1;
		});
		for(int i =0;i<list.size();i++) {
			if((i)>=list.get(i))
				return i;
			answer++;
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 3 ,3}));
	}

}
