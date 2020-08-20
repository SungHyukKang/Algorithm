package jvvv;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek1697 {
    public static int[] place;
    public static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();

        place = new int[100001];
        if(X>=Y){
            System.out.println(Math.abs(Y-X));
            return;
        }
        bfs(X,Y);
        System.out.println(place[Y]);


        for(int Z : place){
            System.out.println(Z);
        }
    }

    public static void bfs(int x, int y){
        queue.offer(x);
        place[x]=0;
        while(!queue.isEmpty()){
            int num = queue.poll();
            if(num==y)
                break;

            if(num-1>=0&&place[num-1]==0){
                queue.offer(num-1);
                place[num-1]=place[num]+1;
            }
            if((num+1<=100000)&&place[num+1]==0){
                queue.offer(num+1);
                place[num+1]=place[num]+1;
            }
            if(num*2<=100000&&place[num*2]==0){
                queue.offer(num*2);
                place[num*2]=place[num]+1;
            }
        }
    }
}
