import java.util.*;
import java.io.*;
public class Baek1072 {

	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
		long target = (Y*100/X)+1;
		if(target==100 || target==101)
			System.out.println("-1");
		long cnt =0;
		long left  = 1;
		long right = 1000000000;
		while(left<=right) {
			long mid =(left+right)/2;
			long val = (Y+mid)*100/(X+mid);
			if(val>=target) {
				right=mid-1;
				cnt=mid;
			}else
				left=mid+1;
		}
		System.out.println(cnt);
	}

}
