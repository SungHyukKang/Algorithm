package ICT;
import java.util.*;
public class TwoStrings {

   public static void commonSubstring(List<String> a, List<String> b) {
	   ArrayList<Set<String>> hssetArr = new ArrayList<>();
	   HashSet<String> hsset =null;
	   boolean tf = true;
	   for(int i = 0 ;i<a.size();i++) {
		   hsset=new HashSet<>();
		   for(int j = 0;j<a.get(i).length();j++) {
			   hsset.add(Character.toString(a.get(i).charAt(j)));
		   }
		   hssetArr.add(hsset);
	   }
	   for(int i = 0;i<hssetArr.size();i++) {
		   tf=true;
		   for(String X : hssetArr.get(i)) {
			   if(tf&&b.get(i).contains(X)) {
				   System.out.println("YES");
				   tf=false;
				   break;
			   }
		   }
		   if(tf) {
			   System.out.println("NO");
		   }
	   }
      }
   
   public static void main(String[] args) {
      ArrayList<String> a = new ArrayList<>();
      ArrayList<String> b = new ArrayList<>();
      a.add("wouldyoulikefries");
      a.add("abcabcabcabcabcabc");
      a.add("hackerrankcommunity");
      a.add("cdecdecdecde");
      
      b.add("jackandjill");
      b.add("wentupthehill");
      b.add("writetoyourparents");
      b.add("fghmqzldbc");
      
      
      
      
      
      TwoStrings.commonSubstring(a, b);
   }

}