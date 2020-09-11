package Greedy;
import java.util.Arrays;
public class Scales {
	public static int solution(int[] weight){
		int answer = 1;
		Arrays.sort(weight);
		for(int i =0;i<weight.length;i++)
			System.out.print(weight[i]+" ");
		for(int w:weight){
			if(answer<w)
				break;
			answer=answer+w;
		}
			return answer;
	}
	public static void main(String[] args) {
		System.out.println(Scales.solution(new int[]{3,1,6,2,7,30,1}));
	}
}
