package jvvv;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek1107 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        int M = Integer.parseInt(br.readLine());
        int currentCh=100;
        int cnt=0;
        StringTokenizer st =new StringTokenizer(br.readLine());
        HashMap<Integer,Integer> hsmap = new HashMap<>();
        for(int i =0;i<10;i++){
            hsmap.put(i,1);
        }
        for(int i =0;i<M;i++){
            hsmap.put(Integer.parseInt(st.nextToken()),0);
        }
        if(currentCh==Integer.parseInt(N)){
            System.out.println("0");
            return;
        }
        int i =0;
        while(currentCh!=Integer.parseInt(N)){
            if(hsmap.get(Integer.parseInt(Character.toString(N.charAt(i))))==1){
            }
        }


    }
}
