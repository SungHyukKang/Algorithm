package StackQueue;

import java.util.Arrays;
import java.util.Comparator;

public class Printer {
	public int solution(int[] priorities , int location){
		Priority[] pr = new Priority[priorities.length];
		for(int i = 0;i<priorities.length;i++){
			pr[i]=new Priority(i,priorities[i]);
		}
		
		Arrays.sort(pr,new Comparator<Priority>(){
			@Override
			public int compare(Priority o1, Priority o2) {
				if(o1.priority<o2.priority){
					return 1;
				}
				else if(o1.priority>o2.priority){
					return -1;
				}
				else
					return 0;
			}
		});
		
		Priority[] answer = new Priority[priorities.length];
		
		int max = pr[0].priority;
		int temp = 0;
		int ptemp = 0;
		int count = 0;
		for(int i = 1 ;i<priorities.length;i++){
				if(max<pr[i].priority)
					max=pr[i].priority;
		}
		for(int i = 0;i<priorities.length;i++){
			for(int j = i ;j<priorities.length;j++){
				if(pr[i].priority==pr[j].priority&&j!=i&&max==pr[i].priority){
					if(pr[i].idx>=pr[j].idx){
						count = j;
						continue;
					}
					else{
						temp = pr[i].idx;
						pr[i].idx=pr[j].idx;
						pr[j].idx=temp;
						count = j;
					}
				}else if(max!=pr[i].priority){
					if(pr[i].idx<pr[j].idx){
						temp = pr[i].idx;
						ptemp = pr[i].priority;
						pr[i].idx=pr[j].idx;
						pr[i].priority=pr[j].priority;
						pr[j].idx=temp;
						pr[j].priority=ptemp;
					}
				}
			}
			
		}
		for(int i = 0 ;i<priorities.length;i++){
			if(i<=count){
				answer[i] = new Priority(pr[i].idx,max);
			}
			else{
				for(int j = priorities.length-1 ;j>count;j--){
					answer[i]=new Priority(pr[j].idx,pr[j].priority);
					i++;
					}
				}
			}
		int ans = 0;
		for(int i = 0 ;i<priorities.length;i++){
			System.out.println("idx :"+pr[i].idx+"prioirity :"+pr[i].priority);
		}
		for(int i = 0 ; i<priorities.length;i++){
			System.out.println(answer[i].priority);
		}
		int ans2 = 0;
		for(ans= 0 ;ans<priorities.length;ans++){
			if(answer[ans].priority==priorities[location]&&location==answer[ans].idx){
				System.out.println("answer[ans].priority :"+answer[ans].priority+"priorities[location] :"+priorities[location]+"answer[ans].idx :"+answer[ans].idx+"ans :"+ans);
				ans2=ans;
			}
		}
		return ans2;
	}	
	public static void main(String[] args) {

		Printer print = new Printer();
		System.out.println(print.solution(new int[]{4,3,6,1,2,9,2,9,1},3));//=>9 9 4 3 6 1 2 2 1  
	}

	class Priority{
		Integer idx = null;
		Integer priority =null;
		Priority(Integer i , Integer d ){
			idx = i;
			priority = d;
		}		
	}
		
}
/* 
		int i;
		if(pr[0].idx==location){
			return location;
		}else{
			for(i = pr[0].idx+1;i!=pr[0].idx;i++){
				if(i==priorities.length){
					i=0;
				}
				if(priorities[i]==priorities[location]){
					System.out.println(i);
					return i;
				}
			}
		}



*/




/*




int counter = pr[0].idx;
int count = 1;
if(counter!=priorities.length-1){
while(counter!=location){
		if(counter==priorities.length)
			counter=0;
		if(counter==location)
			break;
		count++;
		counter++;
	}
}else if(counter==priorities.length-1){
	if(location==counter)
		return 1;
	else{
		return location+2;
	}
}
*/


/*
for(int i = 0 ;i<priorities.length;i++){
			System.out.println("idx :"+pr[i].idx+"prioirity :"+pr[i].priority);
		}
*/