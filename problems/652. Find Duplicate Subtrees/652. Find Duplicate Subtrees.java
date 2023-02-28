/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         thihhs.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        traverse(res,new HashMap<>(),new HashMap<>(),root);
        return res;
    }
    public int traverse(List<TreeNode> res,HashMap<Integer,Integer> cnt,HashMap<String,Integer> Triplet,TreeNode root){
        if(root == null){
            return 0;
        }
        String s_Triplet = traverse(res,cnt,Triplet,root.left) +","+root.val+","+traverse(res,cnt,Triplet,root.right);
        if(!Triplet.containsKey(s_Triplet)){
            Triplet.put(s_Triplet,Triplet.size()+1);
        }
        int id = Triplet.get(s_Triplet);
        cnt.put(id,cnt.getOrDefault(id,0)+1);
        if(cnt.get(id)==2){
            res.add(root);
        }
        return id;
    }
}