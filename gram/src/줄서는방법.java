import java.util.*;

public class 줄서는방법 {
	static int N;
	static int[] answer;
	static ArrayList<Integer> list=new ArrayList<>();
	static boolean tf =false;
	public static int[] solution(int n, long k) {
		answer= new int[n];
        long d=1;
        N=n;
        for(int i =2;i<n;i++){
        	d*=i;
        }
        for(int i =0;i<=n;i++) {
        	list.add(i);
        }
        dfs(0,d,k-1);
        for(int x  :answer)
        	System.out.print(x+" ");
        return answer;
    }
	public static void dfs(int cnt ,long  d ,long k) {
		if(cnt==N-1) {
			answer[answer.length-1]=list.get(1);
			return;
		}
		long first = k/d+1;
		long pro = k%d;
		answer[cnt]=list.remove((int)first);
		dfs(cnt+1,d/(N-cnt-1),pro);
	}
	
	public static void main(String[] args) {
		solution(4,3);
	}

}
	