package KAKAKO2021BLINDRECRUITMENT;
public class Problem3 {
	public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        String[][] nInfo= new String[info.length][5];
        String[][] nQuery = new String[query.length][5];
        int x =0;
        int y =0;
        for(String X : query) {
        	y=0;
        	for(String Z : X.split(" ")) {
        		if(Z.equals("and"))
        			continue;
        		nQuery[x][y++]=Z.trim();
        	}
        	x++;
        }
        x=0;
        String ZZ ="";
        
        for(String X : info) {
        	y=0;
        	for(String Z : X.split(" ")) {
        		if(Z.equals("and"))
        			continue;
        		nInfo[x][y++]=Z.trim();
        	}
        	x++;
        }
        for(int t=0;t<nQuery.length;t++)
        for(int i =0;i<nInfo.length;i++) {
        	String[] arr =nInfo[i];
        	int cnt = 0;
        	for(int j =0;j<5;j++) {
        		if(nQuery[t][j].equals("-")) {
        			cnt++;
        			continue;
        		}
                if(j==4) {
                    	if(nQuery[t][j].equals("-")) {
        				cnt++;
        				continue;
        			}
        			if(Integer.parseInt(arr[j])>=Integer.parseInt(nQuery[t][j])){
        				cnt++;
        				continue;
        			}
        		}
        		if(arr[j].equals(nQuery[t][j])) {
        			cnt++;
        			continue;
        		}
                break;
        	}
        	if(cnt==5) {
        		answer[t]++;
        	}
        }
        for(int i =0;i<answer.length;i++) {
        	System.out.print(answer[i]+" ");
        }
        
        return answer;
    }
	public static void main(String[] args) {
		Problem3 pb = new Problem3();
		pb.solution(new String[] {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
				new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150","java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150","java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"});
	}
}