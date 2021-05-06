import java.util.*;
public class 가장큰수 {
	public String solution(int[] numbers) {
        String answer = "";
        ArrayList<String> nums = new ArrayList<>();
        int i =0;
        for(int x : numbers){
            nums.add(String.valueOf(x));
        }
        Collections.sort(nums,new Comparator<String>(){
            @Override
            public int compare(String o1 , String o2){
                String newstr1=o1+o2;
                String newstr2=o2+o1;
                int x1 = Integer.parseInt(newstr1);
                int x2 = Integer.parseInt(newstr2);
                return -Integer.compare(x1,x2);
            }
        });
       	StringBuilder sb = new StringBuilder();
        boolean tf =false;
        for(String z  : nums){
            if(!z.equals("0"))
                tf=true;
            sb.append(z);
        }
        return tf ? sb.toString():"0";
    }
	public static void main(String[] args) {

	}

}
