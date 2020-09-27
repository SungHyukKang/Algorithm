import java.io.*;
public class Baek20001 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String X = br.readLine();
		int cnt = 0;
		while(true) {
			X=br.readLine();
			if(X.equals("고무오리 디버깅 끝"))
				break;
			if(X.equals("문제")) {
				cnt++;
				continue;
			}
			if(cnt==0&&X.equals("고무오리")) {
				cnt=2;
				continue;
			}
			if(X.equals("고무오리")) {
				cnt--;
				continue;
			}
		}
		if(cnt==0) {
			System.out.println("고무오리야 사랑해");
		}else {
			System.out.println("힝구");
		}
	}

}
