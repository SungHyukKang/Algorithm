
public class NextBigNum {

	public int solution(int n){
		int num=n+1;
		int cnt=0;
		int cnt2=0;
		while(n>0){
			if(n%2==1){
				cnt++;
			}
			n=n/2;
		}
		int t = 0;
		
		while(cnt!=cnt2){
			cnt2=0;
			t=num;
			while(t>0){
				if(t%2==1){
					cnt2++;
				}
				t=t/2;
				
			}
			if(cnt==cnt2){
				break;
			}else
				num++;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		NextBigNum nbn = new NextBigNum();
		nbn.solution(78);
		

	}

}
