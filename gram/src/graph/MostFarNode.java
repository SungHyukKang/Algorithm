package graph;

import java.util.ArrayList;

public class MostFarNode {
	public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<int[]> adj = new ArrayList<>();
        for(int i = 0;i<edge.length;i++) {
        }
        return answer;
    }
	public static void main(String[] args) {
		MostFarNode mfn = new MostFarNode();
		mfn.solution(6, new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
		
	}

}
