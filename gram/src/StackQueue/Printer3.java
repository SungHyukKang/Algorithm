package StackQueue;

import java.util.LinkedList;

public class Printer3 {
class Prior2{
	int idx;
	int prior;
	
	Prior2(int i , int p ){
		this.idx=i;
		this.prior=p;
	}
}
	
	public int solution(int[] priorities , int location){
		LinkedList<Prior2> qu = new LinkedList<>();
		for(int i = 0 ; i<priorities.length;i++){
			qu.add(new Prior2(i,priorities[i]));
		}
		int answer = 1;
		
		Prior2 first = null;
		while(qu.size()>1){
			first=qu.getFirst();
			for(int i = 1;i<qu.size();i++){
				if(first.prior<qu.get(i).prior){
					qu.addLast(first);
					qu.poll();
					break;
				}
				if(i==qu.size()-1){
					if(first.idx==location) return answer;
					qu.poll();
					answer++;
				}
			}
		}
		return answer;
		
	}
	
	public static void main(String[] args) {
		Printer3 ptr = new Printer3();		
		ptr.solution(new int[]{6,1,2,5,6,1,2}, 0);

	}

}
