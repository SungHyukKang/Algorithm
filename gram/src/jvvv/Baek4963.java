
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Baek4963 {
    public static int N;
    public static int M;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int count=0;
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            count=0;
            N = sc.nextInt();
            M = sc.nextInt();
            if(N==0){
                break;
            }
            arr = new int[M][N];
            visited = new boolean[M][N];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && arr[i][j] == 1) {
                        visited[i][j] = true;
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(int x, int y){
        if(isPossible(x+1,y)){
            visited[x+1][y]=true;
            dfs(x+1,y);
        }if(isPossible(x+1,y-1)){
            visited[x+1][y-1]=true;
            dfs(x+1,y-1);
        }
        if(isPossible(x-1,y+1)){
            visited[x-1][y+1]=true;
            dfs(x-1,y+1);
        }
        if(isPossible(x-1,y-1)){
            visited[x-1][y-1]=true;
            dfs(x-1,y-1);
        }
        if(isPossible(x+1,y+1)){
            visited[x+1][y+1]=true;
            dfs(x+1,y+1);
        }
        if(isPossible(x,y+1)){
            visited[x][y+1]=true;
            dfs(x,y+1);
        }
        if(isPossible(x,y-1)){
            visited[x][y-1]=true;
            dfs(x,y-1);
        }
        if(isPossible(x-1,y)){
            visited[x-1][y]=true;
            dfs(x-1,y);
        }
   }
    public static  boolean isPossible(int x ,int y){
        if(x<0||x>=M||y<0||y>=N){
            return false;
        }
        if(arr[x][y]==0||visited[x][y])
            return false;
        return true;
    }
}
