package gram;

public class ���������������ϱ� {

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
		���������������ϱ� sc = new ���������������ϱ�();
				
		sc.solution(new int[]{6,7,2,3,5,1,9});

	}

}
