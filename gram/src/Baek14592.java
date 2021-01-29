import java.util.*;
import java.io.*;

class Participant{
	int i;
	int S;
	int C;
	int L;
	
	
	public Participant(int i ,int s, int c ,int l) {
		this.i=i;
		this.S=s;
		this.C=c;
		this.L=l;
	}
}

public class Baek14592 {
	public static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		ArrayList<Participant> arr = new ArrayList<Participant>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =stoi(br.readLine());
		for(int i =0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr.add(new Participant(i,stoi(st.nextToken()),stoi(st.nextToken()),stoi(st.nextToken())));
		}
		
		Collections.sort(arr,new Comparator<Participant>() {
			@Override
			public int compare(Participant arg0, Participant arg1) {
				if(arg0.S<arg1.S) {
					return 1;
				}else if(arg0.S>arg1.S) {
					return -1;
				}else {
					if(arg0.C<arg1.C) {
						return -1;
					}else if(arg0.C>arg1.C) {
						return 1;
					}else {
						return arg0.L<=arg1.L ? -1 : 1;
					}
				}
			}
		});
		System.out.println(arr.get(0).i+1);
	}

}
