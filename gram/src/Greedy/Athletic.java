package Greedy;

public class Athletic {
	
	public static int solution(int n , int[] lost , int[] reserve){
		int answer= n - lost.length;;
		int count = 0;
		int lost1=0;
		for(int i = 0 ;i<reserve.length;i++){
			for(int j = 0;j<lost.length;j++){
				if(lost[j]==-10&&reserve[i]==-10)
					continue;
				if(lost[j]==reserve[i]){
					lost[j]=-10;
					reserve[i]=-10;
					answer++;
				}
					
			}
		}
		
		for(int i = 0 ;i<lost.length;i++){
			for(int j = 0 ; j<reserve.length;j++){
				if(lost[i]==-10||reserve[j]==-10)
					continue;
				if(reserve[j]+1==lost[i]||reserve[j]-1==lost[i]){
					count++;
					reserve[j]=-1;
					break;
				}
			}
		}
		answer = answer+count+lost1;
		if(answer>n){
			answer=n;
		}
		return answer ;
	}
	
	public static void main(String[] args) {
		System.out.println(Athletic.solution(5,new int[]{2,4},new int[]{3}));
		

	}

}
