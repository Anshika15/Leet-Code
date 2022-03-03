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
    public boolean isUnivalTree(TreeNode root) {
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int prev = root.val;
        
        while(q.size() > 0)
        {
            TreeNode rem = q.removeFirst();
            if(prev != rem.val)
                return false;
            
            if(rem.left != null)
                q.add(rem.left);
            if(rem.right != null)
                q.add(rem.right); 
        }
        return true;
        
    }
}
