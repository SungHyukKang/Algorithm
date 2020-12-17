import java.util.*;
import java.io.*;

class Pair9019 {
	int pre;
	StringBuilder ans = new StringBuilder();

	Pair9019(int pre, String ans) {
		this.pre = pre;
		this.ans.append(ans);
	}

}

public class Baek9019 {
	static String[] DSLR = { "D", "S", "L", "R" };
	static String[] zero= {"0","00","000","0000"};
	static Queue<Pair9019> q = new LinkedList<>();

	public static int stoi(String X) {
		return Integer.parseInt(X);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = stoi(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int target =Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[10000];
			q = new LinkedList<>();
			q.offer(new Pair9019(start, ""));
			visited[start]=true;
			while (!q.isEmpty()) {
				Pair9019 Z = q.poll();
				int pre = Z.pre;
				String ans = Z.ans.toString();
				if (pre==target) {
					bw.write(ans+"\n");
					break;
				}
				for(int x=0;x<4;x++) {
					int xx =func(x,pre);
					if(!visited[xx]) {
						q.offer(new Pair9019(xx, ans+DSLR[x]));
						visited[xx]=true;
					}
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static int func(int x,int val) {
		if(x==0) {
			if(val*2>9999) {
				val=(val*2)%10000;
				return val;
			}else
				return val*2;
		}else if(x==1) {
			if(val==0) {
				return 9999;
			}else
				return val-1;
		}else if(x==2) {//123 -> L -> 1230
			int temp =(val%1000)*10;
			temp+=val/1000;
			return temp;
		}else{//123-> R -> 3012
			int temp = (val%10)*1000;
			temp+=val/10;
			return temp;
		}
		
		
	}
}
