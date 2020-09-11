package noCategory;
import java.util.*;
public class MakePrime {

	public int solution(int[] nums){
		ArrayList<Integer> arr =new ArrayList<>();
		for(int X :nums){
			arr.add(X);
		}
		System.out.println(arr);
		
		return 0;
	}
	
	public static void main(String[] args) {
		MakePrime mp = new MakePrime();
		mp.solution(new int[]{1,2,3,4});
	}

}
