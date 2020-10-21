import java.io.*;
public class Baek2661 {
	static int N;
	static StringBuilder sb=new StringBuilder(); 
	
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		sb.append(1);
		dfs();
	}
	public static void dfs() {
		if(sb.length()==N) {
			System.out.println(sb);
			System.exit(0);
			return;
		}
		for(int i=1;i<=3;i++) {
			if(!Character.toString(sb.toString().charAt(sb.toString().length()-1)).equals(String.valueOf(i))&&isPossible(sb.toString()+i)) {
				sb.append(i);
				dfs();
				String X =sb.toString().substring(0,sb.length()-1);
				sb=new StringBuilder(X);				
			}
		}
	}
	
	public static boolean isPossible(String X) {
		int num =X.length()/2;
		for(int i=2;i<=num;i++) {
			if(X.substring(X.length()-i,X.length()).equals(X.substring(X.length()-i-i,X.length()-i))) {
				return false;
			}
		}
		return true;
	}
	
}
