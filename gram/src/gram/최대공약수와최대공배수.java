package gram;

public class 최대공약수와최대공배수 {
	
	
	/*
	 유클리드 호제법 사용 
	 #기억#
	 */
	public int gcd(int big , int small){
		if(big%small==0)
			return small;
		return gcd(small,big%small);
	}
	public int[] solution(int n , int m){
		
		int big =(int)Math.max(n, m);
		int small=(int)Math.min(n, m);
		
		
		System.out.println(big);
		System.out.println(small);
		int count = 1;
		while(!(count%n==0&&count%m==0)){
			count++;
		}
		int z =gcd((int)Math.max(n, m),(int)Math.min(n, m));
		
		return new int[]{z,count};
	}
	
	public static void main(String[] args) {
		최대공약수와최대공배수 cc = new 최대공약수와최대공배수();
		System.out.println(cc.solution(30, 36)[0]);

	}

}
