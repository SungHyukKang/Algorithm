import java.io.*;
import java.util.*;
public class Baek1085 {
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in ));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		System.out.println(Math.min(Math.min(Math.abs(x-w), Math.abs(y-h)),Math.min(x, y)));
	}

}
