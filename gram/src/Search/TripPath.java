package Search;
import java.util.*;
public class TripPath {
	public static Queue<String> queue= new LinkedList<>();
	public static int size;
	public static boolean[] visit ;
	public static Stack<String> stack = new Stack<>();
	public static String[] answer;
	public static boolean tf =false;
	public static void dfs(String[][] tickets,String path) {
		if(tf) {
			return;
		}
		if(stack.size()==size+1) {
			answer= new String[size+1];
			tf=true; 
			for(int i=0;i<stack.size();i++) {
				answer[i]=stack.get(i);
			}
			return;
		}
		for(int i =0 ;i<tickets.length;i++) {
			if(tickets[i][0].equals(path)&&!visit[i]) {
				visit[i]=true;
				stack.push(tickets[i][1]);
				dfs(tickets,tickets[i][1]);
				stack.pop();
				visit[i]=false;
			}
		}
	}
	
	public String[] solution(String[][] tickets) {
        size=tickets.length;
        visit=new boolean[tickets.length];
        Arrays.sort(tickets, (a, b) -> {
            int comparison = 0;
            comparison = a[0].compareTo(b[0]);
            return comparison == 0 ? a[1].compareTo(b[1]) : comparison;
        });
        stack.push("ICN");
        dfs(tickets,"ICN");
        
        return answer;
    }
	public static void main(String[] args) {
		TripPath tp = new TripPath();
//		tp.solution(new String[][]	{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});
//		tp.solution(new String[][] {{"ICN","JFK"},{"HND","IAD"},{"JFK","HND"}});
//		tp.solution(new String[][] {{"ICN","A"},{"A","B"},{"B","A"},{"A","ICN"},{"ICN","A"}});
//		tp.solution(new String[][] {{"ICN","A"},{"ICN","A"},{"A","ICN"}});
		tp.solution(new String[][] {{"ICN","BOO"}, {"ICN", "COO"}, { "COO", "DOO" }, {"DOO", "COO"}, { "BOO", "DOO"} ,{"DOO", "BOO"}, {"BOO", "ICN" }, {"COO", "BOO"}});
//		tp.solution(new String[][] {{"ICN", "D"}, {"D", "C"}, {"C","ICN"}, {"ICN","B"}, {"B", "E"}});
//		tp.solution(new String[][] {{"ICN","D"},{"D","C"},{"C","ICN"},{"ICN","B"},{"B","E"}});//ICN , D , C , ICN  , B , E
	}

}
