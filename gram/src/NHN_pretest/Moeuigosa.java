package NHN_pretest;

import java.util.Scanner;
import java.util.*;

class Pair{
	int x,y;
	
	Pair(int x, int y){
		this.x=x;
		this.y=y;
	}
}

class Moeuigosa {
	static Queue<Pair> q = new LinkedList<>();
	static boolean[][] visited;
	static int[][] Smatrix;
	static int[] nx= {0,1,0,-1};
	static int[] ny= {1,0,-1,0};
	static int N;
	static int max=0;
  private static void solution(int sizeOfMatrix, int[][] matrix) {
	  N=sizeOfMatrix;
	  Smatrix=matrix;
	  visited=new boolean[sizeOfMatrix][sizeOfMatrix];
	  ArrayList<Integer> sizel = new ArrayList<>();
	  for(int i=0;i<sizeOfMatrix;i++) {
		  for(int j=0;j<sizeOfMatrix;j++) {
			  if(!visited[i][j]&&Smatrix[i][j]==1) {
				  max=1;
				  visited[i][j]=true;
				  dfs(i,j,1);
				  sizel.add(max);
			  }
		  }
	  }
	  Collections.sort(sizel);
	  System.out.println(sizel.size());
	  for(int x : sizel) {
		  System.out.print(x+ " ");
	  }
  }
  
  static void dfs(int x,int y,int cnt) {
	  for(int i =0;i<nx.length;i++) {
		  int mx = x+nx[i];
		  int my = y+ny[i];
		  if(isPossible(mx,my)&&Smatrix[mx][my]==1) {
			  visited[mx][my]=true;
			  max++;
			  dfs(mx,my,max);
		  }
	  }
  }
  
  static int bfs() {
	  int cnt=1;
	  while(!q.isEmpty()) {
		  Pair p = q.poll();
		  int x =p.x;
		  int y= p.y;
		  for(int i = 0;i<nx.length;i++) {
			  int mx = x+nx[i];
			  int my = y+ny[i];
			  if(isPossible(mx,my)&&Smatrix[mx][my]==1) {
				  cnt++;
				  visited[mx][my]=true;
				  q.offer(new Pair(mx,my));
			  }
		  }
	  }
	  return cnt;
  }
  static boolean isPossible(int x, int y) {
	  if(x<0||x>=N||y<0||y>=N) {
		  return false;
	  }
	  if(visited[x][y])
		  return false;
	  return true;
  }
  private static class InputData {
    int sizeOfMatrix;
    int[][] matrix;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));      
      
      inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
      for (int i = 0; i < inputData.sizeOfMatrix; i++) {
        String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
        for (int j = 0; j < inputData.sizeOfMatrix; j++) {
          inputData.matrix[i][j] = Integer.parseInt(buf[j]);
        }
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.sizeOfMatrix, inputData.matrix);
  }
}