public class Prediction {

	public int solution (int n,int a, int b){
		int i =0;
		
		for(i = 0; i<n/2;i++){			
			if(a%2==0)
				a=a/2;
			else{
				a=a/2;
				a++;
			}
			if(b%2==0)
				b=b/2;
			else{
				b=b/2;
				b++;
			}				
			if(a==b){
				break;
			}
		}
		System.out.println(i+1);
		return i+1;
	}
	
	public static void main(String[] args) {
		
		Prediction pd = new Prediction();
		pd.solution(16,8,9);

	}

}
