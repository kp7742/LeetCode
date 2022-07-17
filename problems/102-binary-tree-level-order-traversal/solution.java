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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        //Start with root
        if(root != null)
            queue.add(root);
        
        //BFS on tree
        while(queue.size() > 0){
            int size = queue.size();
            
            //Level list
            List<Integer> level = new ArrayList<>();
            
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                level.add(node.val);

                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            
            result.add(level);
        }
        
        return result;
    }
}