package jvvv;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Baek19538 {
    public static boolean visited[];
    public static int visitedNum[] ;
    public static int arr[][];
    public static int N;
    public static Queue<Integer> queue;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N =sc.nextInt();
        queue = new LinkedList<>();
        arr=new int[N+1][N+1];
        visited=new boolean[N+1];
        int cnt =1;
        for(int i =0;i<N;){
            int num= sc.nextInt();
            if(num==0){
                cnt++;
                i++;
                continue;
            }
            arr[cnt][num]=1;
        }
        int M = sc.nextInt();
        for(int i =0;i<M;i++){
            int number=sc.nextInt();
            for(int j=1;j<=N;j++){
                if(arr[number][j]==1) {
                    queue.offer(j);
                    visited[j]=true;
                    visitedNum[j]=0;
                }
            }
        }
    }
    public static void bfs() {
        
    }

}
