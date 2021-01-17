public class BinaryTranslation {
	public static int[] solution(String s) {
		int[] answer = new int[2];
		while (!s.equals("1")) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '0') {
					s = s.replaceFirst("0", "");
					answer[1]++;
					i--;
				}
			}
			s = Integer.toBinaryString(s.length());
			answer[0]++;
		}
		return answer;
	}
	public static void main(String[] args) {
		solution("110010101001");
	}

}
