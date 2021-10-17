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
    public int pathSum(TreeNode root, int targetSum) {
        
        if(root == null)
            return 0;
        return pathSum_(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
        
    }
    
    int pathSum_(TreeNode root, int targetSum)
    {
        if(root == null)
            return 0;
        if(root.val == targetSum)
            return 1 + pathSum_(root.left, targetSum - root.val) + pathSum_(root.right, targetSum - root.val);
        else
            return 0 + pathSum_(root.left, targetSum - root.val) + pathSum_(root.right, targetSum - root.val);
    }
}
