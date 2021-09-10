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
    public TreeNode buildTree(int[] inorder, int[] postorder, int inStart,int inEnd, int postStart, int postEnd)
    {
        if(inStart > inEnd)
            return null;
         int idx = inStart;
        while(inorder[idx] != postorder[postEnd])
            idx++;
        int countElements = idx - inStart;
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        root.left = buildTree(inorder, postorder, inStart, idx - 1, postStart, postStart + countElements - 1);
        root.right = buildTree(inorder, postorder, idx + 1, inEnd, postStart + countElements, postEnd-1);
        
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return buildTree(inorder, postorder, 0, n-1, 0, n-1);
    }
}
