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
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }
    
    public void dfs(TreeNode node){
        //Base case
        if(node == null)
            return;
        
        //Swap left and right nodes
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        
        //Go further
        dfs(node.left);
        dfs(node.right);
    }
}