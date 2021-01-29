import java.io.*;
public class Baek2998 {
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		sb= sb.reverse();
		int sum=0;
		for(int i =0;i<sb.length();i++) {
			sum+=Math.pow(2*i,Integer.parseInt(Character.toString(sb.charAt(i))));
		}
		sb=new StringBuilder();
		while(sum>0) {
			sb.append(sum%8);
			sum/=8;
		}
		System.out.println(sb.reverse());
	}

}
