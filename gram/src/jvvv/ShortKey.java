package jvvv;

import java.util.ArrayList;
import java.util.Scanner;

public class ShortKey {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		ArrayList<String> word = new ArrayList<>();
		sc.nextLine();
		for(int i = 0;i<N;i++){
			word.add(sc.nextLine()+" ");
		}
		ArrayList<String> key = new ArrayList<>();
		ArrayList<String> answer = new ArrayList<>();
		key.add(" ");
		boolean tf =false;
		for(String X : word){
			tf=true;
			for(String Z : X.split(" ")){
				if(key.contains(Character.toString(Z.charAt(0)).toUpperCase())){
					continue;
				}else{
					key.add(Character.toString(Z.charAt(0)).toUpperCase());
					answer.add(X.replaceFirst(Character.toString(Z.charAt(0)), "["+Character.toString(Z.charAt(0))+"]").trim());
					tf=false;
					break;
				}
			}
			if(tf){
				for(int i =0;i<X.length();i++){
					if(!key.contains(Character.toString(X.charAt(i)).toUpperCase())){
						key.add(Character.toString(X.charAt(i)).toUpperCase());
						answer.add(X.replaceFirst(Character.toString(X.charAt(i)), "["+Character.toString(X.charAt(i))+"]").trim());
						tf=false;
						break;
					}
				}
			}
			if(tf){
				answer.add(X.trim());
			}
		}
		for(String ZZ : answer){
			System.out.println(ZZ);
		}
	}

}
