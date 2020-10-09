package second;
import java.io.*;
 
class Problem2 {
    private static int[][] board;
    private static StringBuilder sb = new StringBuilder("");
    static int zerocnt=0;
    static int onecnt=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
 
        board = new int[n][n];
        for(int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < line.length; j++) {
                board[i][j] = line[j] - '0';
            }
        }
        check(0, 0, n);
        for(int i =0;i<sb.length();i++) {
        	if(sb.charAt(i)=='0') {
        		zerocnt++;
        	}else
        		onecnt++;
        }
        System.out.println(zerocnt);
        System.out.println(onecnt);
    }
 
    private static void check(int y, int x, int n) {
        if(n == 1) {
            sb.append(board[y][x]);
            return;
        }
 
        int init = board[y][x];
        boolean isSame = true;
        out: for(int i = y; i < y+n; i++) {
            for(int j = x; j < x+n; j++) {
                if(board[i][j] != init) {
                    isSame = false;
                    break out;
                }
            }
        }
        if(isSame) {
            sb.append(board[y][x]);
            return;
        }
 
        int half = n >> 1;
        check(y, x, half);
        check(y, x + half, half);
        check(y + half, x, half);
        check(y + half, x + half, half);
    }
}