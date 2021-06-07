import java.util.*;
import java.io.*;

public class Baek2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		ArrayList<String> list = new ArrayList<>();
		list.add("c=");
		list.add("c-");
		list.add("dz=");
		list.add("d-");
		list.add("lj");
		list.add("nj");
		list.add("s=");
		list.add("z=");
		int cnt = 0;
		while (true) {
			if (str.equals("")) {
				break;
			}
			boolean tf = false;
			for (String Z : list) {
				if (str.startsWith(Z)) {
					str = str.substring(Z.length());
					tf = true;
					cnt++;
					break;
				}
			}
			if (!tf) {
				str = str.substring(1);
				cnt++;
			}

		}
		System.out.println(cnt);
	}
}