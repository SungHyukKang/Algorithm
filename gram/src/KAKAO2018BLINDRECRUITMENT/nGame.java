package KAKAO2018BLINDRECRUITMENT;

import java.util.*;

public class nGame {

	String solution(int n ,int t, int m , int p){
		char Z;
		ArrayList<String> arr =new ArrayList<>();
		int gop = t*m;
		int X=0;
		for(int i =gop;i>=0;i--){
			X=i;
			if(i==0){
				arr.add(String.valueOf(i));
			}
		while(X!=0){
			if(X%n>=10){
				Z=(char)('A'+((X%n)-10));
				arr.add(Character.toString((char) Z));
			}else
				arr.add(String.valueOf(X%n));
			X=X/n;
			}
		}
		ArrayList<String> answer =new ArrayList<>();
		StringBuffer sb =new StringBuffer();
		for(int i =arr.size()-1;i>=0;i--){
			answer.add(arr.get(i));
		}
		//i = 0 , 1 , 2 ,3 ,4 ,5 ,6 ,7, 8, 9, 10, 11 ,12 ,13 ,14 ,15 ,16 ,17 ,18 ,19 ,20; 인원 : 5 , 순서 :1번째.  m%i==p;
		
		if(p==1){
			sb.append(answer.get(0));
		}
		for(int i =1 ;i<answer.size();i++){
			
			if(i%m==(p-1)){
				sb.append(answer.get(i));
			}
			if(sb.length()==t)
				break;
		}
		System.out.println(sb);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		nGame ng = new nGame();
		ng.solution(16, 16, 2, 2);

	}

}
