package ElevenST;

public class BinaryGap {
	public static int solution(int N) {
		StringBuilder sb =new StringBuilder();
		int num =0;
		while(N>0) {
			sb.append(N%2);
			N=N/2;
		}
		sb=sb.reverse();
		int cnt =0;
		int max = 0;
		for(int i =0;i<sb.length();i++) {
			if(sb.charAt(i)=='0') {
				cnt++;
			}else {
				if(max<cnt) {
					max=cnt;
				}
				cnt=0;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		solution(2100000001);
	}

}
