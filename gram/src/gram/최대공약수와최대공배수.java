package gram;

public class 최대공약수와최대공배수 {
	
	
	/*
	 ��Ŭ���� ȣ���� ��� 
	 #���#
	 */
	public static int gcd(int big , int small){
		if(big%small==0)
			return small;
		return gcd(small,big%small);
	}
	
	static	int lcm(int a ,int b) {
		return(a*b)/gcd(a,b);
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
		System.out.println(lcm(n,m));
		return new int[]{z,count};
	}
	
	public static void main(String[] args) {
		최대공약수와최대공배수 cc = new 최대공약수와최대공배수();
		System.out.println(cc.solution(4,5)[0]);

	}

}
