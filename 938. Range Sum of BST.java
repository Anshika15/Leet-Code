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
    int count = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        if(root == null)
            return 0;
        rangeSumBST_(root, low, high);
        return count;
        
    }
    
    public void rangeSumBST_(TreeNode node, int d1, int d2) {
        if(node == null)
            return;
        if(d1 < node.val && d2 < node.val)
        {
            rangeSumBST_(node.left, d1, d2);
        }
        else if(d1 > node.val && d2 > node.val)
        {
            rangeSumBST(node.right, d1, d2);
        }
         else
        {
            rangeSumBST_(node.left, d1, d2);
            count += node.val;
            rangeSumBST_(node.right, d1, d2);
        }
    }
}
