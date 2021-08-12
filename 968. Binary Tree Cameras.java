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


/* -1 camera is required 
    0 I have camera
    1 don't need a camera..as I am already covered */

class Solution {
    int cameras = 0;
    public int minCameraCover(TreeNode root) {
        
        int x = minCameraCover_(root);
        if(x == -1)
            cameras++;
        return cameras;
    }
    
    public int minCameraCover_(TreeNode root) {
        
        if(root == null)
            return 1;
        int lchild = minCameraCover_(root.left);
        int rchild = minCameraCover_(root.right);
        
        if(lchild == - 1 || rchild == -1)
        {
            cameras++;
            return 0; // i do have a camera
        }
        
        else if(lchild == 0 || rchild == 0)
        {
            return 1;
        }
        return -1;
        
    }
}
