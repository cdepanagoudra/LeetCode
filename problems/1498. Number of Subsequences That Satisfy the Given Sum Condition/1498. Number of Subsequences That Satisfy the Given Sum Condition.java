class Solution {
	public int numSubseq(int[] nums, int target) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		int MOD = 1000000007;
		int ans = 0;
		for (int i = 1; i <= nums.length; i++) {
			list.add((list.get(i - 1) << 1) % MOD);
		}
		Arrays.sort(nums);
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			if (nums[l] + nums[r] > target) {
				r--;
			} else {
				ans = (ans + list.get(r - l++)) % MOD;
			}
		}
		return ans % MOD;
	}
}