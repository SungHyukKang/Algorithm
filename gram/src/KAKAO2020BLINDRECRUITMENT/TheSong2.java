package KAKAO2020BLINDRECRUITMENT;
import java.util.*;
public class TheSong2 {
	class Musicinfo{
			Integer idx=null;
			Integer start =null;
			Integer end = null;
			String title=null;
			String melody=null;
			Integer time=null;
			StringBuffer sb =new StringBuffer();
			Musicinfo(Integer x,Integer s , Integer e ,String t , String m){
				idx=x;
				start =s;
				end =e;
				title =t;
				if(m.contains("#"))
					for(int i = 0 ;i<m.length();i++){
						if(i!=m.length()-1&&m.charAt(i+1)=='#'){
							sb.append(Character.toLowerCase(m.charAt(i)));
						}else
							sb.append(m.charAt(i));
					}else
						sb.append(m);
				
					melody =sb.toString();
					System.out.println("!!!!!"+melody);
				time=end-start;
			}
		}
	public String solution(String m , String[] musicinfos){
		ArrayList<Musicinfo> mi = new ArrayList<>();
		StringBuffer m2 = new StringBuffer();
		if(m.contains("#"))
		for(int i = 0 ;i<m.length();i++){
			if(i!=m.length()-1&&m.charAt(i+1)=='#'){
				m2.append(Character.toLowerCase(m.charAt(i)));
			}else
				m2.append(m.charAt(i));
		}else
			m2.append(m);
	
		
		System.out.println(m2.toString().replace("#", ""));
		
		for(int i = 0 ;i<musicinfos.length;i++){
			mi.add(new Musicinfo(i,Integer.parseInt(musicinfos[i].split(",")[0].replace(":", "")),Integer.parseInt(musicinfos[i].split(",")[1].replace(":", ""))
					,musicinfos[i].split(",")[2],musicinfos[i].split(",")[3]));
		}
		ArrayList<String> arr =new ArrayList<>();
		StringBuffer sb =null;
		int cnt = 0;
		for(int i = 0;i<musicinfos.length;i++){
			sb=new StringBuffer();
			mi.get(i).melody=mi.get(i).melody.replace("#", "");
			for(int j =0;j<mi.get(i).time;j++){
				sb.append(mi.get(i).melody.charAt(cnt++));
				System.out.println(sb);
				if(cnt==mi.get(i).melody.length()){
					cnt=0;
				}
			}
			arr.add(sb.toString());
			cnt=0;
		}
		ArrayList<Musicinfo> answer = new ArrayList<>();
		for(int i = 0 ;i<arr.size();i++){
			System.out.println("!!!!#!@#"+arr.get(i));
			if(arr.get(i).contains(m2.toString().replace("#",""))){
				answer.add(mi.get(i));
			}
		}
		
		if(answer.size()==1){
			return answer.get(0).title;
		}else if(answer.size()==0){
			return "(None)";
		}else{
			Collections.sort(answer,new Comparator<Musicinfo>(){
			@Override
			public int compare(Musicinfo arg0, Musicinfo arg1) {
				if(arg0.time>arg1.time){
					return -1;
				}else if(arg0.time<arg1.time){
					return 1;
				}else{
					if(arg0.idx>arg1.idx){
						return 1;
					}else if(arg0.idx<arg1.idx){
						return -1;
					}else
						return 0;
				}
			}
		});
			for(int i = 0;i<answer.size();i++){
				System.out.println(answer.get(i).title);
			}
			return answer.get(0).title;
		}
	}
	public static void main(String[] args) {
		TheSong2 ts = new TheSong2();
		System.out.println("!!"+ts.solution("CC",new String[]{"04:00,04:02,ZERO,#BCC", "15:00,15:02,FIRST,#BCC", "04:00,04:02,SECOND,#BCC", "04:00,04:03,THIRD,#BCC"}));
		
	}

}
