package COUPANG;
import java.util.*;
class Solution_4 {
    static int hubcnt=0;
    static int destcnt=0;
    static String destination="";
    static String fndest;
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
        destination = dest;
        dfs2(roads,hub);
        long ans = hubcnt*destcnt;
        answer =(int)(ans%10007);
        return answer;
    }

    public static void dfs(String[][] roads,String start){
        if(start.equals(destination)){
            hubcnt++;
            return;
        }
        for(int i =0;i<roads.length;i++){
            if(roads[i][1].equals(fndest))continue;
            if(roads[i][0].equals(start)&&hsmap.get(start)==0){
                hsmap.put(start,1);
                dfs(roads,roads[i][1]);
                hsmap.put(start,0);
            }
        }   
    }

    public static void dfs2(String[][] roads,String start){
        if(start.equals(destination)){
            destcnt++;
            return;
        }
        for(int i =0;i<roads.length;i++){
            if(roads[i][0].equals(start)&&hsmap.get(start)==0){
                hsmap.put(start,1);
                dfs2(roads,roads[i][1]);
                hsmap.put(start,0);
            }
        }   
    }
    
    public static void main(String[] args) {
    	int Z =(200000*200000)%10007;
    	long S = (200000*200000)%10007;
    	System.out.println(Z);
    	System.out.println(S);
    }
}