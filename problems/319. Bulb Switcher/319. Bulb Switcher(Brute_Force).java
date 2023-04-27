class Solution {
	public int bulbSwitch(int n) {
		int count = 0;
		boolean[] bulb = new boolean[n];
		Arrays.fill(bulb, true);

		for (int round = 2; round <= n; round++) {
			for (int i = round - 1; i < n; i += round) {
				bulb[i] = !bulb[i];
			}
		}
		for (boolean b : bulb) {
			if (b) {
				count++;
			}
		}
		return count;
	}
}