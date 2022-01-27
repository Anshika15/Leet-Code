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
    public int maxPathSum(TreeNode root) {
        
        Pair p = maxPathSum_(root);
        return p.nton;
        
    }
    
    public int maxSum(int... arr)
    {
        int msf = arr[0];
        for(int val : arr)
            msf = Math.max(msf, val);
        return msf;
    }
    
    public Pair maxPathSum_(TreeNode root) {
        
        if(root == null)
            return new Pair();
        Pair lp = maxPathSum_(root.left);
        Pair rp = maxPathSum_(root.right);
        
        Pair myAns = new Pair();
        
        int myrton = Math.max(lp.rton, rp.rton)+root.val;
        
        myAns.nton = maxSum(lp.nton, rp.nton, lp.rton + rp.rton + root.val, root.val, myrton);
        myAns.rton = Math.max(myrton, root.val);
        return myAns;
        
    }
    
    class Pair{
        int nton = Integer.MIN_VALUE;
        int rton = 0;
    }
}
