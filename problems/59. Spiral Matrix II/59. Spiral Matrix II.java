class Solution {

	public int[][] generateMatrix(int n) {
		int[][] ans = new int[n][n];
		int left = 0, right = n - 1, top = 0, bottom = n - 1, numbers = 1;
		while (left <= right) {
			for (int i = left; i <= right; i++) {
				ans[top][i] = numbers++;
			}
			top++;

			for (int i = top; i <= bottom; i++) {
				ans[i][right] = numbers++;
			}
			right--;
			if (top <= bottom) {
				for (int i = right; i >= left; i--) {
					ans[bottom][i] = numbers++;
				}
				bottom--;
			}
			if (left <= right) {
				for (int i = bottom; i >= top; i--) {
					ans[i][left] = numbers++;
				}
				left++;
			}

		}
		return ans;

	}
}
