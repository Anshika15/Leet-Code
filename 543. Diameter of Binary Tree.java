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
    int res = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
    
       solve(root);
        
       if(res == Integer.MIN_VALUE)
           return  0;
       return res;
    }
    public int solve(TreeNode root)
    {
            if(root == null)
                return 0;
            int l = solve(root.left);
            int r = solve(root.right);

            
            res = Math.max(l+r, res);
            return Math.max(l,r) + 1;
    }
}
