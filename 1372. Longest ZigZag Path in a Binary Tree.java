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

class Pair{
    int maxLen = 0;
    int backwardSlope = -1;
    int forwardSlope = -1;
//     Pair(){
        
//     }
    
//     Pair(maxLen, backwardSlope, forwardSlope)
//     {
//         this.maxLen = maxLen;
//         this.backwardSlope = backwardSlope;
//         this.forwardSlope = forwardSlope;
//     }
}

class Solution {
    public int longestZigZag(TreeNode root) {
        
        Pair res = longestZigZag_(root);
        return res.maxLen;
    }
    
    public Pair longestZigZag_(TreeNode root) {
        
        if(root == null)
            return new Pair();
        
        Pair left = longestZigZag_(root.left);
        Pair right = longestZigZag_(root.right);
        Pair ans = new Pair();
        
        ans.maxLen = Math.max(Math.max(left.maxLen, right.maxLen), Math.max(left.backwardSlope, right.forwardSlope)+1);
        
        ans.forwardSlope = left.backwardSlope + 1;
        ans.backwardSlope = right.forwardSlope + 1;
        return ans;
    }
}
