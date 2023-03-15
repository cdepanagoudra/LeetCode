/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	public boolean isCompleteTree(TreeNode root) {
		boolean end = false;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode Curr = queue.poll();
			if (Curr == null)
				end = true;
			else {
				if (end)
					return false;
				queue.add(Curr.left);
				queue.add(Curr.right);
			}
		}
		return true;
	}
}