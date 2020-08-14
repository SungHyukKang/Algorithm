package jvvv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class WordDivide {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	ArrayList<String> arr =new ArrayList<>();
	String X = sc.next();
	StringBuilder sb = null;
	Stack<String> stack =new Stack<>();
	for(int i =1 ; i <X.length()-1;i++){
		for(int j = i+1;j<X.length();j++){
			sb=new StringBuilder();
			for(String Z :X.substring(0,i).split("")){
				stack.push(Z);
			}
			while(!stack.isEmpty())
				sb.append(stack.pop());
			for(String Z :X.substring(i,j).split("")){
				stack.push(Z);
			}
			while(!stack.isEmpty())
				sb.append(stack.pop());
			for(String Z :X.substring(j,X.length()).split("")){
				stack.push(Z);
			}
			while(!stack.isEmpty())
				sb.append(stack.pop());			
			arr.add(sb.toString());
		}
	}
	Collections.sort(arr);
	System.out.println(arr.get(0));
	}
}
