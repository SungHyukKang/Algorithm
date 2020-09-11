package KakaoWinterInternShip;
import java.util.*;


public class Tuple {

	public int[] solution(String s){
		s=s.substring(1,s.length()-1);
		ArrayList<String> arr = new ArrayList<>();
		for(int i = 0;i<s.split("},").length;i++){
			if(i==s.split("},").length-1){
				arr.add(s.split("},")[i].replace("{", "").replace("}", ""));
			}else
				arr.add(s.split("},")[i].replace("{", ""));
		}
		
		Collections.sort(arr,new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				if(o1.length()>o2.length()){
					return 1;
				}else if(o1.length()<o2.length()){
					return -1;
				}else
					return 0;
			}
		});
		int[] ranswer = new int[arr.size()];
		int cnt =0 ;
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(Integer.parseInt(arr.get(0)));
		ranswer[cnt++]=ans.get(0);
		int x= 0;
		for(int i = 1;i<arr.size();i++){
			for(int j =0;j<arr.get(i).split(",").length;j++){
				x =Integer.parseInt(arr.get(i).split(",")[j]);
				if(!ans.contains(x)){
					ans.add(x);
					ranswer[cnt++]=x;
				}
				
			}
		}
		return ranswer;
	}
	
	public static void main(String[] args) {
		
		Tuple tuple = new Tuple();
		
		tuple.solution("{{3},{3,33},{33,3,333},{3333,33,3,333}}");
	}

}
