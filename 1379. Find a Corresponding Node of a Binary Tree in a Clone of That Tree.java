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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(cloned == null)
            return null;
        if(cloned.val == target.val)
            return cloned;
        TreeNode ln = getTargetCopy(original, cloned.left, target);
        if(ln != null)
            return ln;
        
        TreeNode rn = getTargetCopy(original, cloned.right, target);
        if(rn != null)
            return rn;
        return null;
    }
}
