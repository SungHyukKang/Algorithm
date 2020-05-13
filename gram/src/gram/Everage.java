package gram;

public class Everage {

	public double solution(int[] arr){
		double average=0;
		for(int i =0;i<arr.length;i++){
			average+=arr[i];
		}
		return average/arr.length;
		
	}
	public static void main(String[] args) {
		Everage ev = new Everage();
		ev.solution(new int[]{1,2,3,4});

	}

}
