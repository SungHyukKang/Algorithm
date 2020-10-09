package COUPANG;
import java.util.*;
class Solution_4 {
    static int hubcnt=0;
    static int destcnt=0;
    static String destination="";
    static String fndest;
    static Stack<String> stack = new Stack<>();
    static HashMap<String,Integer> hsmap =new HashMap<>();
    public static int solution(String depar, String hub, String dest   , String[][] roads) {
        int answer = -1;
        destination=hub;
        fndest=dest;
        for(int i =0;i<roads.length;i++){
            hsmap.put(roads[i][0],0);
            hsmap.put(roads[i][1],0);
        }
        dfs(roads,depar);
        if(hubcnt==0)
            return 0;
        for(int i =0;i<roads.length;i++){
            hsmap.put(roads[i][0],0);
            hsmap.put(roads[i][1],0);
        }
//        System.out.println(hubcnt);
        destination = dest;
        dfs2(roads,hub);
//        System.out.println(destcnt);
        long ans = hubcnt*destcnt;
        answer =(int)(ans%10007);
//        System.out.println(answer);
        return answer;
    }

    public static void dfs(String[][] roads,String start){
        if(start.equals(destination)){
            hubcnt++;
//            System.out.println(stack);
            return;
        }
        for(int i =0;i<roads.length;i++){
            if(roads[i][1].equals(fndest)) continue;
            if(roads[i][0].equals(start)&&hsmap.get(start)==0){
                hsmap.put(start,1);
//                stack.push(start);
                dfs(roads,roads[i][1]);
//                stack.pop();
                hsmap.put(start,0);
            }
        }   
    }

    public static void dfs2(String[][] roads,String start){
        if(start.equals(destination)){
            destcnt++;
//            System.out.println(stack);
            return;
        }
        for(int i =0;i<roads.length;i++){
            if(roads[i][0].equals(start)&&hsmap.get(start)==0){
                hsmap.put(start,1);
//                stack.push(start);
                dfs2(roads,roads[i][1]);
//                stack.pop();
                hsmap.put(start,0);
            }
        }   
    }
    
    public static void main(String[] args) {
    	solution("a","g","z",new String[][] {{"a","b"},{"a","c"},{"a","e"},{"a","d"},{"a","h"},{"a","g"},{"e","b"},{"b","z"},{"b","g"},{"c","g"},{"d","c"},{"c","z"},{"g","z"}
    	,{"g","x"},{"x","z"},{"g","y"},{"y","t"},{"t","l"},{"l","z"},{"y","l"}});
    }
}