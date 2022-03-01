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
    TreeSet<Integer> set = new TreeSet<>();
    public int findSecondMinimumValue(TreeNode root) {
        solve(root);
        if(set.size() == 1)
            return -1;
        int val = set.first();
        set.remove(val);
        
        return set.first();
    }
    
    public void solve(TreeNode root)
    {
        if(root != null)
        {
            set.add(root.val);
            solve(root.left);
            solve(root.right);
        }
    }
}
