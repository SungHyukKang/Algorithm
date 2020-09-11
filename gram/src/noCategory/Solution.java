package noCategory;
public class Solution {
	public static String[] solution(int n, int[] arr1, int[] arr2) {
	      String[] answer = new String[n];
	      StringBuffer binary = new StringBuffer();
	      StringBuffer code = new StringBuffer();
	      for(int i = 0 ;i <n;i++){
	    	  int orValue= arr1[i] | arr2[i];
	    	  binary.append(Integer.toBinaryString(orValue));
	    	  while(binary.length()<n){
	    		  binary.insert(0,"0");
	    	  }
	    	  for(int j = 0 ;j<binary.length();j++){
	    		Character getChar = binary.charAt(j);
	    			if(getChar.equals('1')){
	    				code.append("#");
	    			}else
	    				code.append(" ");
	    	  }
	    	  answer[	i]=code.toString();
	    	  
	    	  binary.setLength(0);
	    	  code.setLength(0);
	      }
	      return answer;
	      }
	public static void main(String[] args){
		
		int n = 5;
		int[] arr1={2,20,28,18,11};
		int[] arr2={30,1,21,17,28};
		String[] s = new String[n];
		s=Solution.solution(n, arr1, arr2);
		for(int i = 0 ; i< n ;i++){
			System.out.println(s[i]);
		}
		
		
	}
}