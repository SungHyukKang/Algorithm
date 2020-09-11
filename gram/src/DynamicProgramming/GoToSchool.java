package DynamicProgramming;

public class GoToSchool {

	int solution(int m , int n , int[][] puddles ){
		
		int[][] go =new int[n+1][m+1];
		go[1][1]=1;
		for(int[] puddle :puddles){
			go[puddle[1]][puddle[0]]=-1;
		}
		for(int i =1;i<go.length;i++){
			for(int j =1;j<go[i].length;j++){
				if(go[i][j]==-1){
					go[i][j]=0;
				}else{
					if(i==1){
						go[i][j]+=go[i][j-1];
					}else{
						go[i][j]=(go[i][j-1]+go[i-1][j])%1000000007;
					}
				}
			}
		}
		int answer =go[n][m]%1000000007;
		return answer;
	}
	
	public static void main(String[] args) {
		GoToSchool gts = new GoToSchool();
		gts.solution(4,3,new int[][]{{2,2}});

	}

}
