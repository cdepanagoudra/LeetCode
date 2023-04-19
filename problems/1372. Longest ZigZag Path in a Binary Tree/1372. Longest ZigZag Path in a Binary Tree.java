/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	int result;

	void solve(TreeNode root, int dir, int steps) {
		if (root == null)
			return;
		result = Math.max(result, steps);
		if (dir == 1) {
			solve(root.left, 0, steps + 1);
			solve(root.right, 1, 1);
		} else {
			solve(root.right, 1, steps + 1);
			solve(root.left, 0, 1);
		}
	}

	public int longestZigZag(TreeNode root) {
		result = 0;
		solve(root, 0, 0);
		solve(root, 1, 0);
		return result;
	}
}