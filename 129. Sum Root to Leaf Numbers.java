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
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        solution(root, "");
        return ans;
    }
    
    public void solution(TreeNode root, String psf)
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
        {
            String res = psf + root.val;
            int v = Integer.parseInt(res);
            ans = ans + v;
            System.out.println(ans);
            return;
        }
        if(root.left != null)
        solution(root.left, psf + root.val);
        
        if(root.right != null)
        solution(root.right, psf + root.val);
    }
}
