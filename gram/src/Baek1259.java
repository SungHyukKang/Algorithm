import java.io.*;
public class Baek1259 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(Integer.parseInt(sb.append(br.readLine()).toString())!=0) {
			if(sb.toString().equals(sb.reverse().toString())) {
				System.out.println("yes");
			}else
				System.out.println("no");
			sb=new StringBuilder();
		}
	}
}
