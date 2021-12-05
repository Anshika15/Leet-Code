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
    public int rob(TreeNode root) {
        
        if(root == null)
            return 0;
       Pair res = rob_(root);
        return Math.max(res.withRob, res.withoutRob);
        
    }
    
    Pair rob_(TreeNode root)
    {
        if(root == null)
            return new Pair(); 
        Pair l = rob_(root.left);
        Pair r = rob_(root.right);
        
        Pair p = new Pair();
        
        p.withoutRob = Math.max(l.withRob, l.withoutRob) + Math.max(r.withRob, r.withoutRob) ;
        p.withRob = l.withoutRob + r.withoutRob + root.val;
        return p;
    }
}

class Pair{
    int withRob; 
    int withoutRob; 
}
