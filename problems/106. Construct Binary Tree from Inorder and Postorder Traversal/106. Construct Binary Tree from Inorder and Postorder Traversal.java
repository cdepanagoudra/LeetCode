/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return toBST(0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
	}

	public TreeNode toBST(int InorderStart, int InorderEnd, int[] Post, int PostorderStart, int PostorderEnd,
			Map<Integer, Integer> map) {
		if (InorderStart > InorderEnd || PostorderStart > PostorderEnd)
			return null;
		TreeNode root = new TreeNode(Post[PostorderEnd]);
		int rootIndex = map.get(Post[PostorderEnd]);
		int leftTree = rootIndex - InorderStart;
		root.left = toBST(InorderStart, rootIndex - 1, Post, PostorderStart, PostorderStart + leftTree - 1, map);
		root.right = toBST(rootIndex + 1, InorderEnd, Post, PostorderStart + leftTree, PostorderEnd - 1, map);
		return root;
	}
}