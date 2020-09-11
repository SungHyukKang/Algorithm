package KAKAO2020BLINDRECRUITMENT;
import java.util.*;
public class WordArchive {
	
	public int solution(String s){
		String t = null;
		ArrayList<String> arr =new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		LinkedHashMap<String,Integer> hsmap = new LinkedHashMap<>();
		ArrayList<HashMap<String,Integer>> hsmapArr = new ArrayList<>();
		arr.add(s);
		String temp ;
		int j =0;
		for(int q = 2 ; q<s.length()/2;q++) {
			sb=new StringBuilder();
			hsmap=new LinkedHashMap<>();
		for(int i =0;i<s.length()-q;i=i+q){
			System.out.println("Q : "+q);
			hsmap.put(s.substring(i,i+q),hsmap.getOrDefault(s.substring(i,i+q), 0)+1);
			sb.append(s.substring(i,i+q));
			System.out.println(hsmap);
		}
		hsmap.put(s.substring(sb.toString().length(),s.length()),hsmap.getOrDefault(s.substring(sb.toString().length(),s.length()),0)+1);
		hsmapArr.add(hsmap);
		System.out.println("----------");
		}
		System.out.println(hsmapArr);
		return 0;
	}
	public static void main(String[] args){
		WordArchive wa = new WordArchive();				
		wa.solution("abcabcabcabcdededededede");
	}
}
