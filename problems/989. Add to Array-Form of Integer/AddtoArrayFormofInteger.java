package practice;

public class AddtoArrayFormofInteger {
	public List<Integer> addToArrayForm(int[] num, int k) {
		LinkedList<Integer> ans = new LinkedList<>();
		int n = num.length;
		for (int i = n - 1; i >= 0 || k > 0; i--) {
			int sum = k;
			if (i >= 0)
				sum += num[i];
			ans.add(0, sum % 10);
			k = sum / 10;
		}
		return ans;
	}
}
