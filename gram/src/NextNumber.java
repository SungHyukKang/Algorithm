public class NextNumber {
	public static int solution(int n) {
		int answer = 0;
		int num =n;
		String X  =Integer.toBinaryString(num);
		int cnt =0;
		for(int i =0;i<X.length();i++)
			if(X.charAt(i)=='1')
				cnt++;
		boolean tf=true;
		for(int i =n+1;tf;i++) {
			int cnt2=0;
			String X2=Integer.toBinaryString(i);
			for(int j =0;j<X2.length();j++)
				if(X2.charAt(j)=='1')
					cnt2++;
			if(cnt2==cnt) {
				tf=false;
				answer=i;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(78));	
	}

}
