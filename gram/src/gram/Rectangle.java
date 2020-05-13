package gram;

import java.util.*;


public class Rectangle {

	public int[] solution(int[][] v){
			ArrayList<Integer> all = new ArrayList<>();
			ArrayList<Integer> all2 = new ArrayList<>();
				int[] answer = new int[2];
				int cnt = 0;
				for(int i =0;i<v.length;i++){
					for(int x : v[i]){
						if(cnt%2==0)
							all.add(x);
						else
							all2.add(x);
						cnt++;
					}
				}
				for(int i = 0 ; i <3;i++){
					for(int j = 0 ; j<3;j++){
						if(j==i)
							continue;
						if(all.get(i)==all.get(j)){
							all.set(i,-1);
							all.set(j,-1);
						}
						if(all2.get(i)==all2.get(j)){
							all2.set(i,-1);
							all2.set(j,-1);
						}
					}
				}
				for(int zxc : all){
					if(zxc!=-1){
						answer[0]=zxc;
						break;
					}
				}for(int zxc : all2){
					if(zxc!=-1){
						answer[1]=zxc;
						break;
					}
				}
				return answer;
	}
	
	public static void main(String[] args) {
		Rectangle rc = new Rectangle();
		rc.solution(new int[][]{{1,2},{2,2},{1,1}});	

	}

}
