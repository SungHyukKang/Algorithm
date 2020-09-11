package KAKAO2019BLINDRECRUITMENT;

import java.util.*;

public class FailureRate {

	class Rate{
		int stage;
		double failrate =0;
		
		Rate(int stage){
			this.stage=stage;
		}
		
		Rate(int stage , double failure,double length ){
			this.stage = stage;
			failrate=failure/length;
		}
	}
	
	public int[] solution(int N , int[] stages){
		int length =stages.length;
		ArrayList<Rate> arr = new ArrayList<>();
		HashMap<Integer,Integer> hsmap = new HashMap<>();
		for(int X : stages){
			hsmap.put(X, (hsmap.getOrDefault(X, 0)+1));
		}
		System.out.println(hsmap);
		for(int i =1;i<=N;i++){
			System.out.println(i);
			if(hsmap.get(i)==null){
				arr.add(new Rate(i));
				continue;
			}
				arr.add(new Rate(i,(double)hsmap.get(i),(double)length));
			length=length-hsmap.get(i);
		}
		Collections.sort(arr,new Comparator<Rate>(){

			@Override
			public int compare(Rate arg0, Rate arg1) {
				if(arg0.failrate<arg1.failrate){
					return 1;
				}else if(arg0.failrate>arg1.failrate){
					return -1;
				}else
					return 0;
			}
			
		});
		int[] answer = new int[arr.size()];
		for(int i = 0;i<arr.size();i++){
			System.out.println(arr.get(i).stage);
			answer[i]=arr.get(i).stage;
		}
		return answer;
		
	}
	
	public static void main(String[] args) {
		
		FailureRate fr = new FailureRate();

		fr.solution(5, new int[]{1,1,1,1,1,1,1,1,1,1});
		
	}

}
