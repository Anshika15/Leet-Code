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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        
        int n = preorder.length;
        return constructFromPrePost(preorder, postorder, 0, n-1, 0, n-1);
        
    }
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder, int preI, int preEnd, int postI, int postEnd) {
        
        if(preI > preEnd)
            return null;
        TreeNode node = new TreeNode(preorder[preI]);
        
        if(preI == preEnd)
            return node;
        
        int c = postI;
        while(postorder[c] != preorder[preI+1])
            c++;
        int len = c - postI + 1;
        
        node.left = constructFromPrePost(preorder, postorder, preI+1, preI+len, postI, c);
        node.right = constructFromPrePost(preorder, postorder, preI+len+1, preEnd, c+1, postEnd);
        
        return node;
        
    }
}
