import java.util.*;
import java.io.*;

public class Baek1235 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<>();
		for(int i =0;i<N;i++) {
			list.add(br.readLine());
		}
		HashMap<String,Boolean> hsmap = new HashMap<>();
		int size=1;
		while (true) {
			int cnt=0;
			for (int i = 0; i < N; i++) {
				if(hsmap.get(list.get(i).substring(list.get(i).length()-size))==null){
					hsmap.put(list.get(i).substring(list.get(i).length()-size),true);
				}else {
					size++;
					break;
				}
				cnt++;
			}
			if(cnt==list.size()) {
				System.out.println(size);
				break;
			}
		}
	}
}
