package Hash;
import java.util.*;
/*다른 풀이*/
public class Spy2 {

	public int solution(String[][] clothes){
		
		HashMap<String,Integer> hsmap = new HashMap<>();
		for(int i = 0;i<clothes.length;i++){
			if(hsmap.containsKey(clothes[i][1]))
				hsmap.put(clothes[i][1],hsmap.get(clothes[i][1])+1);
			else
				hsmap.put(clothes[i][1],1);
		}
		int answer= 1;
		for(int X :hsmap.values()){
			answer*=(X+1);
		}
		answer=answer-1;
		return answer;
	}
	
	public static void main(String[] args) {
		Spy2 spy2 =new Spy2();
		spy2.solution(new String[][]{{"1","headgear"},{"2","eyewear"},{"3","headgear"},{"4","pants"},{"5","headgear"},{"6","face"},{"7","face"},{"8","face"},{"9","eyewear"}});
	}

}
