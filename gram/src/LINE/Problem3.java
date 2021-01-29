package LINE;

public class Problem3 {
	static boolean[] visited;
	
	public int[] solution(int n) {
        int[] answer = {};
        int size =1;
        while(n/10!=0) {
        	if(n/10!=0) {
        		n=n/10;
        		size++;
        	}
        }
        for(int i =0;i<size;i++) {
        	
        }
        return answer;
    }
	public static void dfs(int n) {
		if(n/10==0) {
			return;
		}
		
		
	}
	
	public static void main(String[] args) {
	Problem3 pb = new Problem3();
	pb.solution(100);
	}
}
