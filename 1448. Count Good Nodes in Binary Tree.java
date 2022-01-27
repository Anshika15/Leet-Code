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
    public int goodNodes(TreeNode root) {
        
        
        if(root == null)
            return 0;
        return solution(root, Integer.MIN_VALUE);
        
    }
    
    public int solution(TreeNode node, int max)
    {
        if(node == null)
            return 0;
        int res = 0;
        if(max <= node.val)
            res = 1;
        max = Math.max(max, node.val);
        int left = solution(node.left, max);
        int right = solution(node.right, max);
        
        res += left+right;
        
        return res;
    }
}
