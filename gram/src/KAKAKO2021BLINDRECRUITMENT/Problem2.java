package KAKAKO2021BLINDRECRUITMENT;
import java.util.*;
public class Problem2 {
	static HashMap<String,Integer> hsmap = new HashMap<>();
	static void reculsion(List<String> arr, List<String> result, int index, int n, int r) {
		
		if (r == 0) {
			String result2 =result.toString().replace("[","").replace(", ","").replace("]",""); 
			hsmap.put(result2,hsmap.getOrDefault(result2, 0)+1);
			return;
		}
		for (int i = index; i < n; i++) {
			result.add(arr.get(i));
			reculsion(arr, result, i + 1, n, r - 1);
			result.remove(result.size() - 1);
		}
	}
	public String[] solution(String[] orders, int[] course) {
		ArrayList<String> result = new ArrayList<>();
		for(String Z : orders) {
			ArrayList<String> arr = new ArrayList<>();
			for(String X : Z.split("")) {
				arr.add(X);
			}
            Collections.sort(arr);
			for(int i =0;i<course.length;i++)
			reculsion(arr, result, 0, arr.size(), course[i]);
		}
		ArrayList<String> arr2 = new ArrayList<>();
		System.out.println(hsmap);
		for(String Z : hsmap.keySet()) {
			if(hsmap.get(Z)>=2) {
				arr2.add(Z);
			}
		}
		System.out.println(arr2);
		ArrayList<String> arr3 = new ArrayList<>();
		for(int i =0;i<course.length;i++) {
			int max =0 ;
			for(int j = 0;j<arr2.size();j++) {
				if(arr2.get(j).length()==course[i]) {
					if(max<hsmap.get(arr2.get(j))) {
						max=hsmap.get(arr2.get(j));
					}
				}
			}
			for(String Z: hsmap.keySet()) {
				if(Z.length()==course[i]) {
					if(hsmap.get(Z)==max) {
						arr3.add(Z);
					}
				}
			}
		}
		Collections.sort(arr3);
		System.out.println(arr3);
		String[] answer = new String[arr3.size()];
		for(int i =0;i<arr3.size();i++) {
			answer[i]=arr3.get(i);
		}
        return answer;
    }
	public static void main(String[] args) {
		Problem2 pb = new Problem2();
		pb.solution(new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD,","ANCDEF"}, new int[] {2,3,5,6});
		
	}
	
}
