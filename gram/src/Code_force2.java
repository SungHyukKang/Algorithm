import java.util.*;
import java.io.*;
public class Code_force2 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i =0;i<N;i++) {
			
			int Z = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean tf = false;
			int cnt=0;
			int sum=0;
			while(st.hasMoreTokens()) {
				String Z1 = st.nextToken();
				if(Z1.equals("1")) {
					sum+=cnt;
					if(tf)
						cnt=0;
					tf=true;
					
				}else if(tf&&Z1.equals("0")) {
					cnt++;
				}else
					continue;
			}
			System.out.println(sum);
		}
		
		
	}

}
