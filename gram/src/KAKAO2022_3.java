import java.util.*;

public class KAKAO2022_3 {

	public static int[] solution(int[] fees, String[] records) {
		int baseTime = fees[0];
		int baseFee = fees[1];
		int unitTime = fees[2];
		int unitFee = fees[3];
		HashMap<Integer, String> inCar = new HashMap<>();
		HashSet<Integer> car = new HashSet<>();
		HashMap<Integer, Integer> totalMinute = new HashMap<>();
		for (String record : records) {
			StringTokenizer st = new StringTokenizer(record);
			String time = st.nextToken();
			int carNum = Integer.parseInt(st.nextToken());
			String state = st.nextToken();
			car.add(carNum);
			if (state.equals("IN")) {
				inCar.put(carNum, time);
			} else {
				String[] sTime = inCar.get(carNum).split(":");
				String[] eTime = time.split(":");
				inCar.remove(carNum);
				int sHour = Integer.parseInt(sTime[0]);
				int eHour = Integer.parseInt(eTime[0]);
				int sMinute = Integer.parseInt(sTime[1]);
				int eMinute = Integer.parseInt(eTime[1]);
				int tMinute = (eHour - sHour) * 60 + eMinute - sMinute;
				totalMinute.put(carNum, totalMinute.getOrDefault(carNum, 0) + tMinute);
			}
		}
		for (int cNum : inCar.keySet()) {
			String[] sTime = inCar.get(cNum).split(":");
			int sHour = Integer.parseInt(sTime[0]);
			int sMinute = Integer.parseInt(sTime[1]);
			int tMinute = (23 - sHour) * 60 + 59 - sMinute;
			totalMinute.put(cNum, totalMinute.getOrDefault(cNum, 0) + tMinute);
		}
		int[][] answer = new int[totalMinute.size()][2];
		int i = 0;
		for (int c : car) {
			answer[i][0] = c;
			int time = totalMinute.get(c);
			if (baseTime >= time) {
				answer[i][1] = baseFee;
			} else {
				if ((time - baseTime) % unitTime != 0) {
					answer[i][1] = unitFee;
				}
				answer[i][1] += baseFee + (Math.ceil((time - baseTime) / unitTime)) * unitFee;
			}
			i++;
		}
		int[] realAnswer = new int[car.size()];
		Arrays.sort(answer, (o1, o2) -> o1[0] - o2[0]);
		for (int z = 0; z < car.size(); z++) {
			realAnswer[z] = answer[z][1];
		}
		return realAnswer;
	}

	public static void main(String[] args) {
		solution(new int[] { 180, 5000, 10, 600 },
				new String[] { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
						"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" });
	}

}
