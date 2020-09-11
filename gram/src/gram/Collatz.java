package gram;

public class Collatz {

	public int solution(long num){
		
		int count = 0;
		while(count!=500){
			if(num==1)
				break;
			if(num%2==0){
				num=num/2;
				count++;
				System.out.println(num);
			}else{
				num=(num*3)+1;
				count++;
				System.out.println(num);
			}
			
		}
		if(count>=500){
			return -1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Collatz tz = new Collatz();
		System.out.println(tz.solution(626331));

	}

}
