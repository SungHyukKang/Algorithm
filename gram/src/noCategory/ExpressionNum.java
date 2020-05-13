package noCategory;

public class ExpressionNum {
	
	public int solution(int n){
		int answer  = 1;
		if(n<=2){
			return 1;
		}
		
		int sum =0;
		int x= 0;
		for(int i = n/2+1;i>=1;i--){
			if(sum==0){
				x=i;
			}
			sum=sum+i;

			if(sum>n){
				sum=0;
				i=x;
			}
			if(sum==n){
				answer++;
				sum = 0;
				i=x;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {

		ExpressionNum en =new ExpressionNum();
		en.solution(3);
		
	}

}
