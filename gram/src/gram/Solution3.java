package gram;
public class Solution3 {
	public static int  solution(String darkResult){
		int[] answer = new int[3];
		int curIdx=0;
		String tempNum="";
		for(char c : darkResult.toCharArray()){
			if(Character.isDigit(c)){
				tempNum=tempNum+c;
				System.out.println(tempNum);
			}else{
				if(!"".equals(tempNum)){
					answer[curIdx++]=Integer.parseInt(tempNum);
					System.out.println("tempNum : " + tempNum);
					System.out.println("answer : "+ answer[curIdx-1]);
					tempNum="";
				}
			}
			switch (c){
			case 'S' :
				answer[curIdx-1]=(int)Math.pow(answer[curIdx-1],1 );
				break;
			case 'D' :
				answer[curIdx-1]=(int)Math.pow(answer[curIdx-1],2 );
				break;
			case 'T' :
				answer[curIdx-1]=(int)Math.pow(answer[curIdx-1],3 );
				break;
			case '*' :
				answer[curIdx-1]=answer[curIdx-1]*2;
				if(curIdx-2>=0){
					answer[curIdx-2]=answer[curIdx-2]*2;
				}
				break;
			case '#' :
				answer[curIdx-1]=answer[curIdx-1]*(-1);
				break;
			}
		}
		
		return answer[0]+answer[1]+answer[2];
	}
	public static void main(String[] args) {
		
		System.out.println(Solution3.solution("5T*2S3T*"));
		
	}

}
