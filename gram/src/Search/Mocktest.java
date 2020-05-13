package Search;
import java.util.*;
public class Mocktest {

	public int[] solution(int[] answers){
		
		int[] st = new int[]{1,2,3,4,5};
		int[] st2 = new int[]{2,1,2,3,2,4,2,5};
		int[] st3 = new int[]{3,3,1,1,2,2,4,4,5,5};
		
		int[] checker = new int[3];
		
		for(int i = 0;i<answers.length;i++){
			if(answers[i]==st[i%5]){
				checker[0]++;
			}
			if(answers[i]==st2[i%8]){
				checker[1]++;
			}
			if(answers[i]==st3[i%10]){
				checker[2]++;
			}			
			}
		int max= checker[0];
		
		for(int i =1 ; i<checker.length;i++){
			if(max<checker[i])
				max=checker[i];
		}
		List<Integer> lr = new ArrayList<>();
		
		for(int i =0;i<checker.length;i++){
			if(max==checker[i])
				lr.add(i+1);
		}
		int[] answer = new int[lr.size()];
		for(int i = 0 ;i<lr.size();i++){
			answer[i]=lr.get(i);
		}
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		Mocktest mt = new Mocktest();
		System.out.println(mt.solution(new int[]{3,2,5,5,3,3,2,5,5,3})[0]);
		
	}

}
