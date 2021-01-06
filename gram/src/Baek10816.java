import java.util.*;
import java.io.*;
public class Baek10816 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N =Integer.parseInt(br.readLine());
		HashMap<Integer,Integer> hsmap =new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int z = Integer.parseInt(st.nextToken());
			hsmap.put(z,hsmap.getOrDefault(z,0)+1);
		}
		int M =Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int z = Integer.parseInt(st.nextToken());
			if(hsmap.get(z)==null)
				bw.write("0 ");
			else
				bw.write(hsmap.get(z)+" ");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}

}
