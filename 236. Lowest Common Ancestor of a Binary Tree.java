/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root, p, q);
        return res;
    }
    
    boolean lca(TreeNode node, TreeNode p, TreeNode q)
    {
        if(node == null)
            return false;
        boolean self = node.val == p.val || node.val == q.val;
        
        boolean left = lca(node.left, p, q);
        if(res != null)
            return true;
        
        boolean right = lca(node.right, p, q);
        if(res != null)
            return true;
        
        if((self == true && left == true) || (self == true && right == true) || (left == true && right == true))
        {
            res = node;
        }
        return self || left || right;
    }
}
