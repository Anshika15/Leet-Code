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
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> res = new ArrayList<>();
        
        binaryTreePaths(root,"", res);
        
        return res;
    }
    
    public void binaryTreePaths(TreeNode root, String asf, List<String> res )
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            res.add(asf + root.val);
            return;
        }
        binaryTreePaths(root.left, asf + root.val + "->", res);
        binaryTreePaths(root.right, asf + root.val + "->", res);
    }
}
