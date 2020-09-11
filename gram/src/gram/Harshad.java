package gram;

public class Harshad {

	public boolean solution(int x){
		int num = x;
		int sum=0;
		while(num!=0){
			sum=num%10+sum;
			num=num/10;
		}
		
		
		
		if(x%sum==0)
			return true;
		else 
			return false;
		
		
	}
	
	public static void main(String[] args) {
		Harshad hs =new Harshad();
		hs.solution(18);

	}

}
