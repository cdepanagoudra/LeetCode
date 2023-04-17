class Solution {
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> ans = new ArrayList<>(candies.length);
		int g = 0;
		for (int candy : candies) {
			g = Math.max(candy, g);
		}
		g -= extraCandies;

		for (int candy : candies) {
			ans.add(candy >= g);
		}
		return ans;
	}
}