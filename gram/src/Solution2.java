import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Rate implements Comparable<Rate>{
	
	int num ;
	double rate ; 
	Rate(int num , double rate){
		this.num=num;
		this.rate = rate;
	}
	
	@Override
	public int compareTo(Rate o){
		int r = new Double(this.rate).compareTo(o.rate)*-1;
				if(r==0){
					r=this.num-o.num;
				}
		return r;
	}
	
}

public class Solution2 {
	public static double[] solution(int N , int[] stages){
		double[] answer=new double[N];
		ArrayList<Integer> stage = new ArrayList<Integer>();
		Rate[] rates = new Rate[N];
		for(int X : stages){
			stage.add(X);
		}		
		int length =  stage.size();
		Collections.sort(stage);
		int num = stage.get(0);
		int count =0;
		int i = 0;
		for(int Z : stage){
			if(num == Z){
				count++;
				continue;
			}else{
				answer[i]=(double)count/length;
				length=length-count;
				count=1;
				i++;
				num=Z;
			}
		}
		
		for(int g = 0 ; g<N;g++){
			rates[g]=new Rate(g+1,answer[g]);
		}
		Arrays.sort(rates);
		for(i = 0 ; i<N;i++){
			answer[i]=rates[i].num;
		}		
		return answer;
	}
	
	public static void main(String[] args) {
		int N=4;
		int[] stages={3,3,3,3,2,4,3,2,1};
		//1,2,2,2,3,3,4,6
		//일단 stages 배열을 정렬.
		//1/8 , 3 / 7 , 2 / 4 , 1 / 2 / , 0 / 1
		// 
		for(int i = 0 ; i < N ; i++){
			System.out.println(Solution2.solution(N, stages)[i]);
		}
		
		}

}
