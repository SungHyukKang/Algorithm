package Hash;

import java.util.*;

public class BestAlbum {
	
	class Playlist{
		String genre=null;
		int playing=0;
		int genrefull=0;
		int idx ;
		int prior;
		Playlist(String g ,int p,int i){
			genre=g;
			playing=p;
			idx=i;
		}
	}
	public int[] solution(String[] genres , int[] plays){
		Map<String,Integer> hsmap = new HashMap<>();
		Map<String,Integer> hsmap2 = new HashMap<>();
		ArrayList<Playlist> list = new ArrayList<>();
		for(int i =0;i<plays.length;i++){
			if(hsmap.get(genres[i])==null){
				hsmap.put(genres[i], plays[i]);
				hsmap2.put(genres[i], 1);
			}
			else{
				hsmap.put(genres[i], hsmap.get(genres[i])+plays[i]);
				hsmap2.put(genres[i], hsmap2.get(genres[i])+1);
			}
			list.add(new Playlist(genres[i],plays[i],i));
		}
		for(int i = 0 ;i<list.size();i++){
			list.get(i).genrefull=hsmap.get(list.get(i).genre);
		}
		Collections.sort(list,new Comparator<Playlist>(){
			@Override
			public int compare(Playlist arg0, Playlist arg1) {
				if(arg0.genrefull<arg1.genrefull){
					return 1;
				}else if(arg0.genrefull>arg1.genrefull)
					return -1;
				else {
					if(arg0.playing<arg1.playing){
						return 1;
					}else if(arg0.playing>arg1.playing)
						return -1;
					else{
						if(arg0.idx>arg1.idx){
							return 1;
						}else if(arg0.idx<arg1.idx){
							return -1;
						}else
							return 0;
					}
				}
			}		
		});
		for(int i = 0;i<list.size();i++){
			list.get(i).prior=i;
		}
		for(String Z : genres){
			if(hsmap2.get(Z)>2){
				for(int i = list.size()-1;i>=0;i--){
					if(list.get(i).genre.equals(Z)){
						if(hsmap2.get(Z)<=2)
							break;
							list.remove(i);
						hsmap2.put(Z,hsmap2.get(Z)-1);
					}
				}
			}
		}
		int[] answer = new int[list.size()];
		for(int i =0 ;i<list.size();i++){
			answer[i]=list.get(i).idx;
			System.out.println(answer[i]);
		}
		return answer;
	}
	
	public static void main(String[] args){
		BestAlbum ba =new BestAlbum();
		ba.solution(new String[]{"a","b","c","d","e","f","a","a"}, new int[]{1,2,3,4,5,6,3,1});
	}
}
