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
    public int maxDepth(TreeNode root) {
        //Base case
        if(root == null)
            return 0;
        
        //Queue start from root
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int maxLevel = 0;
        
        //BFS
        while(queue.size() > 0){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            
            maxLevel++;
        }
        
        return maxLevel;
    }
}