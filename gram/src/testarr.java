
public class testarr {

	public static void main(String[] args) {
		
		int[] arr= {1,2,3,4};
		int[] cpy= {3,4};
		System.out.println(arr[0]);
		cpy=arr;
		cpy[0]=2;
		
		System.out.println(arr[0]);
		
		
		
	}

}
