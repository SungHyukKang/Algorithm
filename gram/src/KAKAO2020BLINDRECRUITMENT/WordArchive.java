package KAKAO2020BLINDRECRUITMENT;
import java.util.*;
public class WordArchive {
	
	public int solution(String s){
		String t = null;
		StringBuffer sb = new StringBuffer();
		ArrayList<StringBuffer> arr =new ArrayList<>();
		int cnt=1;
		for(int i =2;i<=s.length()/2;i++){
			sb=new StringBuffer();
			for(int j=i ,q =0 ;j<=s.length();j=j+i,q=q+i){
				if(q==0){
					t=s.substring(q,j);
				}else{
					
					if(t.equals(s.substring(q,j))){
						System.out.println(t);
						cnt++;
						if(j==s.length()){
							sb.append(cnt+t);
							cnt=1;

						}
					}else{
						if(cnt!=1){
							sb.append(cnt+t);
							cnt=1;
							System.out.println(t);
						}
						t=s.substring(q,j);
					}
				}
			}
			arr.add(sb);
			cnt=1;
		}
		Collections.sort(arr,new Comparator<StringBuffer>(){
			@Override
			public int compare(StringBuffer arg0, StringBuffer arg1) {
				if(arg0.length()<arg1.length()){
					return 1;
				}else if(arg0.length()>arg1.length()){
					return -1;
				}else
					return 0;
			}
			
		});
		
		System.out.println(arr);
		if(arr.isEmpty()){
			return s.length();
		}
		return arr.get(0).length();
	}
	public static void main(String[] args){
		WordArchive wa = new WordArchive();				
		wa.solution("abcabcdede");
	}
}
