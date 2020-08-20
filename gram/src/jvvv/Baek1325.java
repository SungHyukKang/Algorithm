package jvvv;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek1325 {
    public static ArrayList<Integer>[] arr;
    public static int N;
    public static boolean[] visited;
    public static int M;
    public static int cnt= 0;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        HashMap<Integer,Integer> hsmap = new HashMap<>();
        arr=new ArrayList[N+1];
        for(int i =1;i<=N;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i =0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int num1=Integer.parseInt(st.nextToken());
            int num2=Integer.parseInt(st.nextToken());
            arr[num2].add(num1);
        }
        int max = -1;
        for(int i =1;i<=N;i++){
            visited=new boolean[N+1];
            cnt = 0;
            dfs(i);
            if(max<=cnt) {
                max = cnt;
                hsmap.put(i,cnt);
            }
        }
        System.out.println(hsmap);

        for(int i =1;i<=N;i++){
            if(hsmap.containsKey(i))
            if(hsmap.get(i)==max){
                sb.append(i+" ");
            }
        }
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void dfs(int start){
        visited[start]=true;
        for(int i : arr[start]){
            if(!visited[i]){

                dfs(i);
                cnt++;
            }
        }
    }
}

