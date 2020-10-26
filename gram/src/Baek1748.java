import java.io.*;
public class Baek1748 {
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int X =Integer.parseInt(br.readLine());
		int num =X;
		int length=0;
		while(num>0) {
			num=num/10;
			length++;
		}
		int answer=0;
		for(int i =0;i<length-1;i++) {
			answer+=(int)Math.pow(10,i)*9*(i+1);
		}
		int Z =X-(int)Math.pow(10,length-1)+1;
		answer+=Z*length;
		System.out.println(answer);
	}

}
