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
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }
    
    public void dfs(TreeNode node, List<Integer> res, int level){
        //Base case
        if(node == null)
            return;
        
        //Only one node from one level
        if(res.size() == level)
            res.add(node.val);
        
        //Priority to right node before left
        dfs(node.right, res, level + 1);
        dfs(node.left, res, level + 1);
    }
}