package gram;

public class �ڸ������ϱ� {

		public int solution(int n){
			int answer =0;
			while(n!=0){
				answer+=n%10;
				n=n/10;
			}
			return answer;
		}
	
	public static void main(String[] args) {
		�ڸ������ϱ� jm = new �ڸ������ϱ�();
		jm.solution(987);
		
	}

}
	