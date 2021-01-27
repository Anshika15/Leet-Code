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
    public boolean isBalanced(TreeNode root) {
        if(root != null)
        {
             int l = height(root.left);
            int r = height(root.right);
            if(Math.abs(l - r) > 1)
                return false;
            return isBalanced(root.left) && isBalanced(root.right);
        }
           
        return true;
    }
    int height(TreeNode root)
    {
        return heightRec(root);
    }
    
    int heightRec(TreeNode root)
    {
        if(root == null)
            return 0;
        else
        {
            int l = heightRec(root.left);
            int r = heightRec(root.right);
            if(l > r)
                return l+1;
            else
                return r+1;
        }
    }
    
}
