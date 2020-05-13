package KAKAO2020BLINDRECRUITMENT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class TheSong3 {
	class Music{
		int idx ;
		int time;
		String name;
		String melody;
		Music(int i ,int time ,String name , String melody){
			this.idx=i;
			this.time = time;
			this.name=name;
			this.melody=melody;
		}
	}
	public String solution(String m , String[] musicinfos){
		m = m.replace("C#", "c").replace("D#","d").replace("E#","e").replace("F#","f").replace("G#","g").replace("A#","a").replace("B#","b");
		ArrayList<Music> arr =new ArrayList<>();
		String melody=null;
		for(int i = 0 ;i<musicinfos.length;i++){
			melody=null;
			melody=musicinfos[i].split(",")[3].replace("C#", "c").replace("D#","d").replace("E#","e").replace("F#","f").replace("G#","g").replace("A#","a").replace("B#","b");
			arr.add(new Music(i,(Integer.parseInt(musicinfos[i].split(",")[1].replace(":",""))-Integer.parseInt(musicinfos[i].split(",")[0].replace(":", ""))),
					 musicinfos[i].split(",")[2],melody));
		}
		ArrayList<String> mel =new ArrayList<>();
		int cnt = 0;
		StringBuffer sb =new StringBuffer();
		for(int i =0;i<arr.size();i++){
			sb=new StringBuffer();
			for(int j =0;j<arr.get(i).time;j++){
				if(cnt == arr.get(i).melody.length()){
					cnt=0;
				}
				sb.append(Character.toString(arr.get(i).melody.charAt(cnt++)));
			}
			mel.add(sb.toString());
			cnt=0;
		}
		ArrayList<Music> answer =new ArrayList<>();
		for(int i =0;i<mel.size();i++){
			if(mel.get(i).contains(m)){
				answer.add(arr.get(i));
			}
		}
		if(answer.size()>0){
			Collections.sort(answer,new Comparator<Music>(){
				@Override
				public int compare(Music o1, Music o2) {
					if(o1.time<o2.time){
						return 1;
					}else if(o1.time>o2.time){
						return -1;
					}else
						return 0;
				}
			});
		}else if(answer.size()==0){
			return "(None)";
		}
		return answer.get(0).name;
	}
	public static void main(String[] args) {
		TheSong3 ts =new TheSong3();
		System.out.println(ts.solution("ABC",new String[]{"13:00,13:09,HELLO,ABC#ABC#ABC","13:00,13:09,HELLO2,ABC#ABC#ABC","13:00,13:09,HELLO3,ABC#ABC#ABC"}));		
	}
}