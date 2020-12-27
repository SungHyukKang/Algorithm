public class skillcheck_no3 {
	public static int solution(String dirs) {
		boolean[][][][] visited = new boolean[10][10][10][10];
		int cnt = 0;
		int x = 5;
		int y = 5;
		for (String X : dirs.split("")) {
			int nx = x;
			int ny = y;
			if (X.equals("U")) {
				nx--;
			}else if(X.equals("D")) {
				nx++;
			}else if(X.equals("L")) {
				ny--;
			}else {
				ny++;
			}
			
			if(nx<0||nx>=10||ny<0||ny>=10)
				continue;
			if(!visited[x][y][nx][ny]) {
				visited[x][y][nx][ny]=true;
				visited[nx][ny][x][y]=true;
				cnt++;
			}
			x=nx;
			y=ny;
			
		}
		return cnt;

	}

	public static void main(String[] args) {
		System.out.println(solution("LULLLLLLU"));
	}
}
