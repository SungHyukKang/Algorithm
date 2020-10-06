	import java.io.*;
public class Baek2023 {
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		dfs("",0);
		System.out.println(sb.toString());
	}

	static boolean isPossible(int Z) {
		if(Z==1)
			return false;
		for(int i =2;i<Z;i++) {
			if(Z%i==0)
				return false;
		}
		return true;
	}
	
	static void dfs(String s,int length) {
		if(N==length) {
			sb.append(s+"\n");
			return;
		}
			for(int i=1;i<=9;i++) {
				if(isPossible(Integer.parseInt(s+i))) {
					dfs(s+i,length+1);
				}
		}
		
	}
	
}
