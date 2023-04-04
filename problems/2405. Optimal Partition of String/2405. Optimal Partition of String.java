class Solution {
	public int partitionString(String s) {
		int[] partition = new int[26];
		int res = 0;
		int last = 0;
		for (int i = 0; i < s.length(); i++) {
			if (partition[s.charAt(i) - 'a'] >= last) {
				res++;
				last = i + 1;
			}
			partition[s.charAt(i) - 'a'] = i + 1;
		}
		return res;
	}
}