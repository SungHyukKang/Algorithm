	package gram;

public class SecretMap {

	public String[] solution(int n , int[] arr1 , int[] arr2){
		String[] answer =new String[n];
		int[][] array1 = new int[n][n];
		int[][] array2 = new int[n][n];
		int[][] sum = new int[n][n];
		StringBuffer[] sb = new StringBuffer[n];
		
		for(int i = 0 ;i<n;i++){
			sb[i]=new StringBuffer("");
			for(int j = 0 ;j<n;j++){
			array1[i][n-j-1]=arr1[i]%2;
			arr1[i]=arr1[i]/2;
			array2[i][n-j-1]=arr2[i]%2;
			arr2[i]=arr2[i]/2;
			if(array1[i][n-j-1]+array2[i][n-j-1]==2)
				sum[i][n-j-1]=1;
			else
				sum[i][n-j-1]=array1[i][n-j-1]+array2[i][n-j-1];
			}
		}
		for(int i = 0;i<n;i++){
			for(int j = 0;j<n;j++){
				sb[i].append(sum[i][j]);	
			}
			answer[i]=sb[i].toString().replaceAll("1", "#").replaceAll("0"," ");	
		}
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		SecretMap sm = new SecretMap();
		System.out.println(sm.solution(5, new int[]{9,20,28,18,11}, new int[]{30,1,21,17,28})[2]);

	}

}
