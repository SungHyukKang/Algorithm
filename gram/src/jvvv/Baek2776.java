package jvvv;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek2776 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		HashMap<Integer,Boolean> hsmap=null;

		for(int i =0;i<T;i++){
			int N= Integer.parseInt(br.readLine());
			
			hsmap=new HashMap<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =0;j<N;j++){
				int num=Integer.parseInt(st.nextToken());
				hsmap.put(num,true);
			}
			int M =Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<M;j++){
				if(hsmap.containsKey(Integer.parseInt(st.nextToken()))){
					bw.write("1\n");
				}else{
					bw.write("0\n");
				}
			}
			
		}
		bw.flush();
		bw.close();
		br.close();
		
		
	}

}
