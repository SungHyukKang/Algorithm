package ElevenST;
public class No2 {
	public static int[] solution(String[] S) {
		int[] ans = new int[3];
		int M = S[0].length();
		for(int i =0;i<S.length;i++) {
			for(int j=i;j<S.length;j++) {
				if(i==j)
					continue;
				for(int k =0;k<M;j++) {
					if(S[i].charAt(k)==S[j].charAt(k)) {
						ans[0]=i;
						ans[1]=j;
						ans[2]=k;
						return ans;
					}
				}
			}
		}
        return new int[]{};
    }
	public static void main(String[] args) {
		solution(new String[] {"zzzz","ferz","zdsr","fgtd"});
	}

}
