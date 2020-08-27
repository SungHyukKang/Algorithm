package jvvv;
import java.util.*;

class Pair{
    int x,y;

    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Baek7576 {
    public static int[][] arr;
    public static Queue<Pair> queue;
    public static int N;
    public static int M;
    public static int count=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M][N];
         queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j]==1){
                    queue.offer(new Pair(i,j));
                }
            }
        }
        if(queue.isEmpty()){
            System.out.println("-1");
            return;
        }

        bfs();
        for(int i =0;i<M;i++){
            for(int j =0;j<N;j++){
                if(arr[i][j]==0){
                    System.out.println("-1");
                    return;
                }
            }
        }
        System.out.println(count);
    }
    public static void bfs(){
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            if(isPossible(pair.x+1,pair.y)){
                arr[pair.x+1][pair.y]=arr[pair.x][pair.y]+1;
                queue.offer(new Pair(pair.x+1,pair.y));
            }
            if(isPossible(pair.x-1,pair.y)){
                arr[pair.x-1][pair.y]=arr[pair.x][pair.y]+1;
                queue.offer(new Pair(pair.x-1,pair.y));
            }
            if(isPossible(pair.x,pair.y+1)){
                arr[pair.x][pair.y+1]=arr[pair.x][pair.y]+1;
                queue.offer(new Pair(pair.x,pair.y+1));
            }
            if(isPossible(pair.x,pair.y-1)){
                arr[pair.x][pair.y-1]=arr[pair.x][pair.y]+1;
                queue.offer(new Pair(pair.x,pair.y-1));
            }
            count=arr[pair.x][pair.y]-1;
        }
    }

    public static boolean isPossible(int x,  int y){
        if(x<0||x>=M||y<0||y>=N){
            return false;
        }
        if(arr[x][y]!=0||arr[x][y]==-1)
            return false;
        return true;
    }


}
