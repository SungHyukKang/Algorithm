package BruteForce;

import java.util.*;

public class BlackJack {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc =new Scanner(System.in);
		ArrayList<Integer> arr =new ArrayList<>();
		int N =sc.nextInt();
		int M= sc.nextInt();
		for(int i =0;i<N;i++){
			arr.add(sc.nextInt());
		}
		ArrayList<Integer> answer =new ArrayList<>();
		for(int i =0;i<arr.size()-2;i++){
			for(int j =i+1;j<arr.size()-1;j++){
				for(int k=j+1;k<arr.size();k++){
					System.out.println("i : " + i +" j : "+j+" k : "+k);
					if(arr.get(i)+arr.get(j)+arr.get(k)<=M){
						answer.add(arr.get(i)+arr.get(j)+arr.get(k));
					}
				}
			}
		}
		Collections.sort(answer);
		System.out.println(answer.get(answer.size()-1));
	}

}
