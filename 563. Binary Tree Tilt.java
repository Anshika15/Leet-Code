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
    
    int tilt = 0;
    public int findTilt(TreeNode root) {
        
        findTilt_(root);
        return tilt;
        
    }
    
    int findTilt_(TreeNode root)
    {
        if(root == null)
            return 0;
        int l = findTilt_(root.left);
        int r = findTilt_(root.right);
        
        tilt += Math.abs(l-r);
        return l+r+root.val;
    }
}
