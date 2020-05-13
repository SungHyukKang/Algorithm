package gram;

public class CaesarCipher {
	
	
	public String solution(String s , int n){
		StringBuffer answer = new StringBuffer();
		char word =' ';
		int aaa =0;
		for(int i =0 ; i<s.length();i++){
			aaa=0;
			word=s.charAt(i);
			if(word==' '){
				answer.append(word);
				continue;
			}
			else if((word>='a'&&word<='z')){
				if((word+n)>'z'){
					aaa='a'+(int)(word+n-'z'-1);
					word=(char)(aaa);
					
				}else
					word=(char)(word+n);
			}else if(((word>='A'&&word<='Z'))){
				if(word+n>'Z'){
					aaa='A'+(int)(word+n-'Z'-1);
					word=(char)(aaa);
				}else
					word=(char)(word+n);
			}	
			answer.append(word);
		}
		
		return answer.toString();
	}
	
	public static void main(String[] args){
		
		CaesarCipher cc =new CaesarCipher();
		System.out.println(cc.solution("   ",5));
	}
	
}
