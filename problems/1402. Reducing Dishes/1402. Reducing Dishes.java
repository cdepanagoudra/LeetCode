class Solution {
	public int maxSatisfaction(int[] satisfaction) {
		int n = satisfaction.length;
		Arrays.sort(satisfaction);
		int total = 0, res = 0;

		for (int i = n - 1; i >= 0 && satisfaction[i] > -total; i--)

		{
			total += satisfaction[i];
			res += total;
		}
		return res;
	}
}