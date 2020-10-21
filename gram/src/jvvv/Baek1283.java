package jvvv;

import java.util.*;
import java.io.*;
public class Baek1283 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> word = new ArrayList<>();
		HashMap<String,Boolean> hsmap = new HashMap<>();
		
		
		
		for(int i =0;i<N;i++)
			word.add(br.readLine());
		for(int i =0;i<N;i++) {
			String Z =word.get(i);
			StringTokenizer st = new StringTokenizer(Z);
			boolean tf =true;
			while(st.hasMoreTokens()) {
				String T = st.nextToken();
				if(hsmap.get(Character.toString(T.charAt(0)).toUpperCase())==null) {
					hsmap.put(Character.toString(T.charAt(0)).toUpperCase(),true);
					tf=false;
					break;
				}
			}
			if(tf) {
				for(int j=0;j<Z.length();j++) {
					if(Z.charAt(j)!=' '&&hsmap.get(Character.toString(Z.charAt(j)).toUpperCase())==null) {
						hsmap.put(Character.toString(Z.charAt(j)).toUpperCase(),true);
						break;
					}
				}
			}
		}
		ArrayList<String> answer = new ArrayList<>();
		for(String Z : word) {
			StringTokenizer st=new StringTokenizer(Z);
			String T="";
			boolean tf=false;
			while(st.hasMoreTokens()) {
				String X = st.nextToken();
				if(!tf&&hsmap.get(Character.toString(X.charAt(0)).toUpperCase())){
					hsmap.put(Character.toString(X.charAt(0)).toUpperCase(),false);
					X=X.replaceFirst(Character.toString(X.charAt(0)), "["+Character.toString(X.charAt(0))+"]");
					tf=true;
				}
				T+=X+" ";
			}
			T=T.trim();
			if(T.equals(Z)) {
				for(int j=0;j<Z.length();j++) {
					if(Z.charAt(j)!=' '&&hsmap.get(Character.toString(Z.charAt(j)).toUpperCase())) {
						hsmap.put(Character.toString(Z.charAt(j)).toUpperCase(),false);
						T=T.replaceFirst(Character.toString(Z.charAt(j)),"["+Character.toString(Z.charAt(j))+"]");
						break;
					}
				}
			}
			answer.add(T);
		}
		
		for(String ZZ : answer) {
			System.out.println(ZZ);
		}
	}

}
