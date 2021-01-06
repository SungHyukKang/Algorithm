import java.util.*;
import java.io.*;

class Pair11651{
	int x;
	int y;
	public Pair11651(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Baek11651 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Pair11651> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			String[] Z = br.readLine().split(" ");
			int x = Integer.parseInt(Z[0]);
			int y = Integer.parseInt(Z[1]);
			list.add(new Pair11651(x,y));
		}
		
		Collections.sort(list,new Comparator<Pair11651>() {
			@Override
			public int compare(Pair11651 arg0, Pair11651 arg1) {
				if(arg0.y<arg1.y) {
					return -1;
				}else if(arg0.y==arg1.y) {
					return arg0.x<=arg1.x ? -1:1;
				}
				return 1;
			}
		});
		
		for(Pair11651 p : list){
			System.out.println(p.x+" "+p.y);
		}
	}

}
