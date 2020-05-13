package gram;

public class 제일작은수제거하기 {

	public int[] solution(int[] arr){
		int min = arr[0];
		int j =0;
		if(arr.length<=1)
			return new int[]{-1};
		
		for(int i = 1;i<arr.length;i++){
			if(min>arr[i]){
				min=arr[i];
			}
		}
		int[] answer = new int[arr.length-1];
		for(int z : arr){
			if(z==min)
				continue;
			answer[j++]=z;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		제일작은수제거하기 sc = new 제일작은수제거하기();
				
		sc.solution(new int[]{6,7,2,3,5,1,9});

	}

}
