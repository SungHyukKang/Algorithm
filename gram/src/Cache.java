
import java.util.*;

public class Cache {

	public int solution(int cacheSize , String[] cities){
		int answer = 0;
		int idx= 0 ;
		if(cacheSize==0){
			return 5*cities.length;
		}
		ArrayList<String> arr = new ArrayList<>();
		for(String Z :cities){
			String X = Z.toUpperCase();
			if(!arr.contains(X)){
				
				answer=answer+5;
				if(cacheSize>0){
					if(cacheSize<=arr.size()){
						arr.remove(0);
					}
				}
				arr.add(X);
			}
			else{
				idx =arr.indexOf(X);
				arr.remove(idx);
				arr.add(X);
				answer=answer+1;
			}
		}
		return answer;
		}
	
	public static void main(String[] args) {
		Cache cc = new Cache();
		cc.solution(3, new String[]{"A","B","C","D","D","A","C"});

	}

}
