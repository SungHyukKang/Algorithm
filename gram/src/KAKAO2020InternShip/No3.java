package KAKAO2020InternShip;
import java.util.*;
class Pair{
	int start;
	int end;
	int d=end-start;
	Pair(int s , int e){
		start=s;
		end=e;
	}
}
public class No3 {
	public int[] solution(String[] gems) {
		HashMap<String,Integer> hsmap = new HashMap<>();
        HashSet<String> hsset = new HashSet<>();
        ArrayList<Pair> arr =new ArrayList<>();
        for(String Z : gems){
        	hsset.add(Z);
        }
    return answer;
    }
	public static void main(String[] args) {		
		No3 no = new No3();
		no.solution(new String[]{"A", "A", "D", "B", "A","A","D","B","Z","A"});
	}

}
