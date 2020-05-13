package Hash;
import java.util.*;

public class Ponketmon {

	public int solution(int[] nums){
		HashSet<Integer> hsset = new HashSet<>();
		for(int X : nums){
			hsset.add(X);
		}
		if(nums.length/2<=hsset.size()){
			return nums.length/2;
		}else
			return hsset.size();
		
	}
	
	public static void main(String[] args) {
		
		Ponketmon pk = new Ponketmon();
		pk.solution(new int[]{3,3,3,3,2,4});
	}

}
