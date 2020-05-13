package BruteForce;

public class Carpett {

	public int[] solution(int brown , int red){
		int width=0;
		int sum = brown+red;
		int[] arr =null;

		for(width =3;width<=sum/2;width++){
			for(int j = 3 ;j<=width;j++){
				if(width*j==sum&&(width*2+(j-2)*2)==brown){
					arr=new int[]{width,j};
				}
			}
		}
		for(int i = 0;i<1;i++){
			System.out.println(arr[0]);
			System.out.println(arr[1]);
		}
		
		
		return arr;
	}
	
	public static void main(String[] args) {
		Carpett cp = new Carpett();
		
		cp.solution(28, 36);
		
	}

}
