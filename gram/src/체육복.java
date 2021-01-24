import java.util.*;
public class 체육복 {
	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		HashMap<Integer, Boolean> hsmap = new HashMap<>();
		HashMap<Integer, Integer> hsmap2 = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			hsmap.put(i, false);
			hsmap2.put(i, 1);
		}
		for (int i = 0; i < lost.length; i++) {
			hsmap.put(lost[i], true);
			hsmap2.put(lost[i], hsmap2.get(lost[i]) - 1);
		}
		for (int i = 0; i < reserve.length; i++) {
			hsmap.put(reserve[i], false);
			hsmap2.put(reserve[i], hsmap2.get(reserve[i]) + 1);
		}

		for (int i = 1; i <= n; i++) {
			if (hsmap.get(i)) {
				if (i - 1 > 0 && hsmap2.get(i - 1) == 2) {
					hsmap.put(i, false);
					hsmap2.put(i - 1, 1);
				} else if (i + 1 <= n && hsmap2.get(i + 1) == 2) {
					hsmap.put(i, false);
					hsmap2.put(i + 1, 1);
				}
			}
		}

		for (Boolean tf : hsmap.values())
			if (!tf)
				answer++;
		return answer;
	}

	public static void main(String[] args) {
		solution(5,new int[] {2,4},new int[] {1,3,5});//5
	}
}


/*
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
 */
