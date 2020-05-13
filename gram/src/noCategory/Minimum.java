package noCategory;
import java.util.*;
public class Minimum {
	public int solution(int[] A , int[] B){
		ArrayList<Integer> arr =new ArrayList<>();
		ArrayList<Integer> arr2 =new ArrayList<>();
		for(int i = 0;i<A.length;i++){
			arr.add(A[i]);
			arr2.add(B[i]);
		}
		int sum=0;
		Collections.sort(arr);
		Collections.sort(arr2,Collections.reverseOrder());
		for(int i = 0;i<arr.size();i++){
			sum+=arr.get(i)*arr2.get(i);
		}
		return sum;
	}
	public static void main(String[] args) {
		Minimum m = new Minimum();
		m.solution(new int[]{1,4,2}, new int[]{5,4,4});

	}

}
