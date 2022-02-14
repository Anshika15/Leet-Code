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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        if(nums.length == 0)
            return null;
        
        return constructMaximumBinaryTree(nums, 0, nums.length-1);
    }
    
    TreeNode constructMaximumBinaryTree(int[] nums, int start, int end)
    {
        if(start > end)
            return null;
        int max = Integer.MIN_VALUE;
        int idx = start;
        for(int i = start; i <= end; i++){
            if(nums[i] > max)
            {
                max = nums[i];
                idx = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = constructMaximumBinaryTree(nums, start, idx-1);
        node.right = constructMaximumBinaryTree(nums, idx+1, end);
        return node;
    }
}
