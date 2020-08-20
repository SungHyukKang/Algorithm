import java.util.Scanner;

public class Baek11724 {
    public static int[][] arr;
    public static boolean visited[];
    public static int N;
    public static int M;
    public static int cnt =1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N =sc.nextInt();
        M =sc.nextInt();
        arr =new int[N+1][N+1];
        int ans =0;
        visited=new boolean[N+1];
        for(int i =1;i<=M;i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            arr[v1][v2]=1;
            arr[v2][v1]=1;
        }
        for(int i =1;i<=N;i++){
            if(cnt==N)
                break;
            if(!visited[i]) {
                ans++;
                dfs(i);
                visited[i]=true;
            }

        }

        System.out.println(ans);
    }

    public static void dfs(int start){
        for(int i =1;i<=N;i++){
            if((arr[start][i]==1||arr[i][start]==1)&&!visited[i]){
                visited[i]=true;
                cnt++;
                dfs(i);
            }
        }
    }
}
