import java.util.*;

public class Fibonacci {

	public int solution(int n){
		ArrayList<Integer> arr =new ArrayList<>();
		arr.add(0);
		arr.add(1);
		for(int i =2 ;i<n;i++){
			arr.add((arr.get(i-2)%1234567)+(arr.get(i-1)%1234567));
		}
		return arr.get(arr.size()-1);
	}
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		f.solution(7);

	}

}
