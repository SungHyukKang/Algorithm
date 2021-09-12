import java.util.*;

class KAKAO2022_4 {
	int max = 0;
	Stack<Integer> stack = new Stack<>();
	HashMap<Integer, ArrayList<int[]>> hsmap = new HashMap<>();

	public int[] solution(int n, int[] info) {
		dfs(n, info, 0, 0, 0);
		ArrayList<int[]> list;
		hsmap.put(0, new ArrayList<>());
		list = hsmap.get(max);
		if (list.size() > 1)
			Collections.sort(list, new Comparator<int[]>() {
				@Override
				public int compare(int[] arg0, int[] arg1) {
					if (arg0[10] < arg1[10]) {
						return 1;
					} else if (arg0[10] == arg1[10]) {
						if (arg0[9] < arg1[9])
							return 1;
						else if (arg0[9] == arg1[9]) {
							if (arg0[8] < arg1[8])
								return 1;
							else if (arg0[8] == arg1[8]) {
								if (arg0[7] < arg1[7])
									return 1;
								else if (arg0[7] == arg1[7]) {
									if (arg0[6] < arg1[6])
										return 1;
									else if (arg0[6] == arg1[6]) {
										if (arg0[5] < arg1[5])
											return 1;
										else if (arg0[5] == arg1[5]) {
											if (arg0[4] < arg1[4])
												return 1;
											else if (arg0[4] == arg1[4]) {
												if (arg0[3] < arg1[3])
													return 1;
												else if (arg0[3] == arg1[3]) {
													if (arg0[2] < arg1[2])
														return 1;
													else if (arg0[2] == arg1[2]) {
														if (arg0[1] < arg1[1])
															return 1;
														else if (arg0[1] == arg1[1]) {
															if (arg0[0] < arg1[0])
																return 1;
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					return -1;
				}
			});
		return list.size() == 0 ? new int[] { -1 } : list.get(0);
	}

	public void dfs(int n, int[] info, int depth, int idx, int sum) {
		if (idx == 11) {
			boolean[] visited = new boolean[11];
			for (int i = 0; i < stack.size(); i++) {
				visited[stack.get(i)] = true;
			}
			int apeach = 0;
			for (int i = 0; i < 11; i++) {
				if (!visited[i] && info[i] > 0) {
					apeach += 10 - i;
				}
			}
			if (max <= (sum - apeach) && sum > apeach) {
				max = sum - apeach;
				int[] ans = new int[11];
				if (depth != n) {
					ans[10] += n - depth;
				}
				for (int i = 0; i < 11; i++) {
					if (visited[i]) {
						ans[i] = info[i] + 1;
					}
				}
				if (hsmap.get(sum - apeach) == null) {
					hsmap.put(sum - apeach, new ArrayList<>());
				}
				hsmap.get(sum - apeach).add(ans);
			}
			return;
		}
		if (depth + info[idx] + 1 <= n) {
			stack.push(idx);
			dfs(n, info, depth + info[idx] + 1, idx + 1, sum + 10 - idx);
			stack.pop();
		}
		dfs(n, info, depth, idx + 1, sum);
	}

	public static void main(String[] args) {
		KAKAO2022_4 k = new KAKAO2022_4();
//		k.solution(5, new int[] { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 });
		k.solution(9, new int[] { 0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1 });
//		System.out.println(Arrays.toString(k.solution(1, new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 })));
//		k.solution(10, new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 });
	}

}
