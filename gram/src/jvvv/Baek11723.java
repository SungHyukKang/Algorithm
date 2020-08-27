package jvvv;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek11723 {
    public static HashMap<Integer,Integer> hsmap = new HashMap<>();
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static class val{
        int y;

        val(){

        }
        val(String x){
            if("all".equals(x)){
                for(int i =1;i<=20;i++){
                    hsmap.put(i,1);
                }
            }else
                for(int i =1;i<=20;i++){
                    hsmap.put(i,0);
                }
        }
        val(String x ,int y)throws Exception{
            if("add".equals(x)){
                hsmap.put(y,1);
            }else if("check".equals(x)){
                if(hsmap.get(y)==1){
                    bw.write("1\n");
                }else
                    bw.write("0\n");
            }else if("remove".equals(x)){
                hsmap.put(y,0);
            }else if("toggle".equals(x)){
                if(hsmap.get(y)==0){
                    hsmap.put(y,1);
                }else
                    hsmap.put(y,0);
            }
            this.y=y;
        }
    }

    public static void main(String[] args)throws Exception {


        int X = Integer.parseInt(br.readLine());
        val vl = new val();
        Queue<String> queue = new LinkedList<>();
        for(int i =1;i<=20;i++){
            hsmap.put(i,0);
        }
        for(int i = 0;i<X;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                queue.offer(st.nextToken());
            }
            if(queue.size()==1){
                new val(queue.poll());
            }else
                new val(queue.poll(),Integer.parseInt(queue.poll()));
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
