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
    
    int difference = Integer.MAX_VALUE;
    int val = -1;
    public int getMinimumDifference(TreeNode root) {
        
        if(root == null)
            return 0;
        if(root.left != null)
            getMinimumDifference(root.left);
        if(val != -1)
            difference = Math.min(difference, Math.abs(root.val - val));
        val = root.val;
        if(root.right != null)
            getMinimumDifference(root.right);
        return difference;
    }
}
