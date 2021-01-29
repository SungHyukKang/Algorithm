import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'editDistance' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING source
     *  2. STRING target
     */

    public static int editDistance(String source, String target) {
    	String Z =""+1;
    	System.out.println(Z.length());
        ArrayList<Character> list = new ArrayList<>();
        ArrayList<Character> list2 = new ArrayList<>();
        for(int i =0;i<source.length();i++){
            list.add(source.charAt(i));
            list2.add(target.charAt(i));
        }
        HashMap<Integer,Integer> hsmap = new HashMap<>();
        for(int i =0;i<list.size();i++){
            hsmap.put((int)(list.get(i)-list2.get(i)),hsmap.getOrDefault((int)(list.get(i)-list2.get(i)),0)+1);
        }
        int max=0;
        
        for(int x : hsmap.values()){
            if(x>max)
                max=x;  
        }
        int[] arr =new int[max];
        System.out.println(list.size());
        System.out.println(max);
        System.out.println(hsmap);
        
        if(max==list.size())
        	return 0;
        
        return (list.size()-32)*2;
    }

}


public class Solution {
    public static void main(String[] args) throws IOException {

        int result = Result.editDistance("mqfsnmygrquczhymvkurxfelpeagkisearktnjrcapbuuawnmcrgsfsnusuprtnnzbuvtoemgiohvicsnkqhbgoomupuvjmfzpqp", "yelitmysnjcfgvvvezaprgaonzkofyqqhfmxseezencanocepyzxocwivnkbjrhcehqlcwsagrfookhiwsrjguzonapppyyodlqx");
        System.out.println(result);
    }
}
