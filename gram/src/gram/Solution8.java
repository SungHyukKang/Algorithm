package gram;
import java.util.*;
public class Solution8 {
	
	public class Fail{
		int stage;
		double Rate;
		
		Fail(int stage , double Rate){
			this.stage =stage;
			this.Rate = Rate;
		}
	}
	
	Comparator<Fail> comp = new Comparator<Fail>(){
		@Override
		public int compare(Fail a , Fail b){
			if(a.Rate<b.Rate)
				return 1;
			else if(a.Rate>b.Rate)
				return -1;
			else{
				if(a.stage>b.stage)
					return 1;
				else if(a.stage<b.stage){
					return -1;
				}else
					return 0;
			}
		}
	};
	
	
	public int[] solution(int N , int[] stages){
		int[] answer = new int[N];
		List<Fail> fails = new ArrayList<Fail>();
		int total =stages.length;
		
		int[] users = new int[N+1];
		for(int s : stages)
			users[s-1]++;
		for(int i  = 0 ; i<N;++i){
			if(users[i]==0){
				fails.add(new Fail(i+1,0));
			}else {
				fails.add(new Fail(i+1,(double)users[i]/total));
				total-=users[i];
			}
		}
		
		Collections.sort(fails, new Comparator<Fail>(){
			@Override
			public int compare(Fail a, Fail b) {
				if(a.Rate<b.Rate)
					return 1;
				else if(a.Rate>b.Rate)
					return -1;
				else{
					if(a.stage>b.stage)
						return 1;
					else if(a.stage<b.stage)
						return -1;
					else 
						return 0;
				}
			}
			
		});
		
		for(int i = 0 ;i<N ;++i){
			answer[i]=fails.get(i).stage;
		}
		
		
		return answer;
	}
	public static void main(String[] args) {
		int N = 4;
		int[] stages = {4,4,4,4,4};
		Solution8 S=new Solution8();
		for(int i = 0 ;i<N;i++)
		System.out.println(S.solution(N,stages)[i]);
		
		
	}

}
