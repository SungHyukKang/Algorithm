package noCategory;
import java.util.*;
import java.util.Map.Entry;
public class sol {

	static public int[] solution(int[][] v){
		
		HashMap<Integer,Integer> hsmapX=new HashMap<>();
		HashMap<Integer,Integer> hsmapY=new HashMap<>();
		for(int i =0;i<v.length;i++){
			for(int j =0;j<v[i].length;j++){
				if(j%2==0){
					hsmapX.put(v[i][j],hsmapX.getOrDefault(v[i][j], 0)+1);
				}else
					hsmapY.put(v[i][j],hsmapY.getOrDefault(v[i][j], 0)+1);
			}
		}
		int x =0;
		int y= 0;
		for(Entry<Integer, Integer> entry:hsmapX.entrySet()){
			if(entry.getValue()==1){
				x=entry.getKey();
			}
		}
		for(Entry<Integer, Integer> entry:hsmapY.entrySet()){
			if(entry.getValue()==1){
				y=entry.getKey();
			}
		}
		
		return new int[]{x,y};
	}
	
	public static void main(String[] args) {
		
		solution(new int[][]{{1,4},{3,4},{3,10}});
		
	}

}
