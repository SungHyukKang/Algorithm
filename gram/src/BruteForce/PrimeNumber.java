package BruteForce;
import java.util.*;
public class PrimeNumber {
	public int solution(String numbers){
			ArrayList<String> arr =new ArrayList<>();
			for(int i =0;i<numbers.length();i++){
				arr.add(Character.toString(numbers.charAt(i)));
			}
			System.out.println(arr);
			HashSet<String> hsset = new HashSet<>(); 
			StringBuffer sb =null;
			for(int i = 0;i<arr.size();i++){
				hsset.add(arr.get(i));
				sb=new StringBuffer();
				sb.append(arr.get(i));
				for(int j =0;j<numbers.length();j++){
					if(i!=j){
						hsset.add(sb.append(arr.get(j)).toString());
						System.out.println(sb);
					}
				}
			}
			ArrayList<Integer> intarr = new ArrayList<>();
			for(String X : hsset){
				if(Integer.parseInt(X)==0||Integer.parseInt(X)==1)
					continue;
				intarr.add(Integer.parseInt(X));
			}
			int cnt =0;
			boolean tf = true;
			for(int i = 0 ;i<intarr.size();i++){
				tf=true;
				if(intarr.get(i)>=3){
				for(int j =2;j<=intarr.get(i)/2;j++){
						if(intarr.get(i)%j==0){
							tf=false;
							break;
						}
					}
				}
				if(tf){
					cnt++;
				}
			}
			return cnt;
	}
	
	public static void main(String[] args){
		
		PrimeNumber pn =new PrimeNumber();
		System.out.println(pn.solution("1235784"));
		
	}
}
