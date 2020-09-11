package StackQueue;

import java.util.*;

public class Function {

	class Doc{
		int progresses;
		int speeds;
		int days=0;
		Doc(int p ,int s){
			progresses = p;
			speeds = s;
		}
		Doc plus(){
			progresses+=speeds;
			days++;
			return this;
		}
	}
	
	public int[] solution(int[] progresses ,int[] speeds){
		ArrayList<Doc> list = new ArrayList<>();
		ArrayList<Integer> al=new ArrayList<>();
		
		for(int i = 0 ;i<progresses.length;i++){
		list.add(new Doc(progresses[i],speeds[i]));
		}
		for(int i = 0 ;i<progresses.length;i++){
		while((list.get(i).progresses<100)){
				list.get(i).plus();
			}
		}
		
		int cnt = 1;
		int j = 0;
		
		while(true){
			if(list.get(j).days>=list.get(j+1).days){
				list.remove(j+1);
				cnt++;
			}else{
				j++;
				al.add(cnt);
				cnt=1;
			}
			if(list.size()-1==al.size()){
				al.add(cnt);
				break;
			}
		}
		
		int[] answer = new int[al.size()];
		int count = 0 ;
		for(int zz : al){
			answer[count++]=zz;
		}
		
		
		return answer;
	}
	public static void main(String[] args) {
		
		Function fc = new Function();
		fc.solution(new int[]{98,99,97,96,94},new int[]{1,1,1,1,1});

	}

}
