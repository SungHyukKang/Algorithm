package gram;

public class World124 {
	public String solution(int n){
		     int num = n;
				String answer ="";
				while(n>0){
					num=n%3;
					n=n/3;
					if(num==0){
							num=4;
							n=n-1;
					}
					answer=num+answer;
				}
				
				return answer;
	}
	
	public static void main(String[] args){
			World124 world = new World124();
			world.solution(7);
	}
}
