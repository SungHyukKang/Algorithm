package gram;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* 
 못 풀었다.
 소고기 먹고 다시 풀어보자.

 */

public class FilenameSort {
	class Number{
		int idx;
		int num;
		Number(int idx ,int num){
			this.idx=idx;
			this.num=num;
		}
	}	
	
	class Head{
		int idx ;
		String head;
		
		Head(int idx , String tail){
			this.idx=idx;
			this.head=tail;
		}
	}
	
	public String[] solution(String[] files){
		ArrayList<Head> head = new ArrayList<Head>();
		ArrayList<Number> number = new ArrayList<Number>();
		String numPattern="^[0-9]*$";
		String[] copy = new String[files.length];
		int cc=0;
		for(String qq: files){
			copy[cc++]=qq;
		}
		boolean tf =false;
		char t ;
		int count = 0;
		int start=0;
		int end=0 ;
		int headS=0;
		for(String x : copy){
			copy[count]=x.toLowerCase();
			for(int i = 0 ;i<copy[count].length();i++){
				
				t =copy[count].charAt(i);
				tf = Pattern.matches(numPattern, String.valueOf(t));
				if(tf){
					if(start==0){
						start = i;
					}else{
						end =i;
					}
				}
				if(!tf){
					if(headS==0)
						headS=i;
				}
			}
			if(end!=0){
				number.add(new Number(count,Integer.parseInt(copy[count].substring(start,end+1))));	
			}else
				number.add(new Number(count,Integer.parseInt(copy[count].substring(start,start+1))));
			
			if(start !=0)
				head.add(new Head(count,copy[count].substring(headS-1,start)));
			else
				head.add(new Head(count,copy[count].substring(headS-1)));
			start =0;
			end = 0;
			headS=0;
			count++;
		}
			
		return files;
	}
	public static void main(String[] args) {
		FilenameSort fns = new FilenameSort();
		fns.solution(new String[]{"F-5 Freedom Fighter","A-80", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat","F-7 ASXX"});
	}
}
/*

String[] he = new String[files.length];
		int[] num = new int[files.length];
		for(int i = 0 ; i<files.length;i++){
			num[i]=Integer.parseInt(number.get(i).num);
		}
		for(int i = 0 ;i<files.length;i++){
			he[i]=head.get(i).head;
		}
		
		
		int counter=0;
		String[] temp = new String[files.length];
		cc=0;
		for(String qq: files){
			temp[cc++]=qq;
		}
		Arrays.sort(temp);
		
		Arrays.sort(files);
		for(counter = 0 ;counter<he.length;counter++){
			for(int v = 0 ; v<files.length;v++){
				if(he[counter].equals(head.get(v).head)){
					if(num[counter]>Integer.parseInt(number.get(v).num)){
						files[counter]=files[v];
						files[v]=temp[counter];			
					}
				}
			}
		}



*/