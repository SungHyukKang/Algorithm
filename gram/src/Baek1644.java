import java.util.*;
import java.io.*;
public class Baek1644 {
	public static void main(String[] args)throws IOException {
		BufferedReader br  = new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw  = new BufferedWriter (new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Boolean> list2 = new ArrayList<>();
		for(int i=0;i<=N;i++) {
			list2.add(false);
		}
		
		for(int i=2;i<=(int)Math.sqrt(N);i++) {
			if(!list2.get(i)) {
				for(int j=i*i;j<=N;j=j+i) {
					list2.set(j, true);
				}
			}
		}
		for(int i=2;i<list2.size();i++) {
			if(!list2.get(i)) {
				list.add(i);
			}
		}
		int s = 0,e=0;
		int sum=0;
		int cnt=0;
		while(true) {
			if(sum>=N) {
				sum-=list.get(s);
				s++;
			}else if(e==list.size()) {
				break;
			}else {
				sum+=list.get(e);
				e++;
			}
			if(sum==N)
				cnt++;
		}
		bw.write(cnt+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
