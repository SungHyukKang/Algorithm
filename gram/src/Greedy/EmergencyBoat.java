package Greedy;
import java.util.Arrays;
public class EmergencyBoat {
	public static int solution(int[] people , int limit){
		int answer = people.length;
		Arrays.sort(people);
		int j =people.length-1;
		int i =0;
		for(i = 0 ;i<j;j--){
			if(i+1!=people.length)
			if(people[i]+people[j]<=limit){
				System.out.println("i:"+i);
				answer--;
				i++;
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		System.out.println(EmergencyBoat.solution(new int[]{40,40,70,100}, 140));
	}
}
