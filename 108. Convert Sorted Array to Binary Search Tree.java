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
    public TreeNode sortedArrayToBST(int[] nums) {
        
        if(nums.length == 0)
            return null;
        TreeNode node = buildTree(nums, 0, nums.length-1);
        return node;    
    }
    
    TreeNode buildTree(int arr[], int start, int end)
    {
        if(start > end)
            return null;
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = buildTree(arr, start,mid-1);
        node.right = buildTree(arr, mid+1, end);
        return node;
    }
}
