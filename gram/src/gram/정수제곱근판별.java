package gram;

public class 정수제곱근판별 {

	public long solution(long n){
		int count =1;
		while(Math.pow(count, 2)!=n){
			if(n<Math.pow(count, 2)){
				return -1;
			}
			count++;
			
		}
		return (long)Math.pow(count+1, 2);
	}
	
	public static void main(String[] args) {

		정수제곱근판별 xx = new 정수제곱근판별();
		System.out.println(xx.solution(3));

	}

}

/*
다른 사람의 풀이
sqrt가 생각 안나서 대충 풀었는데 , 역시 요렇게 푸는게 훨씬 빠름 . 
if(Math.pow((int)Math.sqrt(n),2)==n){
			return (long) Math.pow(Math.sqrt(n)+1, 2);
		}else
			return -1;

*/
