package ElevenST;

public class FrogJump {
	public static int solution(int X, int Y, int D) {
		double answer=0;
		double YtoX=Y-X;
		answer=Math.ceil((double)YtoX/D);
		return (int)answer;
	}

	public static void main(String[] args) {
		solution(10,85,30);
	}

}
