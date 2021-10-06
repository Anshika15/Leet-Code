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
    public void recoverTree(TreeNode root) {
         recoverTree_(root);
         if(a != null)
        {
            int tem = a.val;
            a.val = b.val;
            b.val = tem;
        }
    }
    
    TreeNode prev = null;
    TreeNode a = null;
    TreeNode b = null;
    public void recoverTree_(TreeNode root) {
          if(root != null){
          recoverTree_(root.left);
          if(prev != null && prev.val > root.val)
          {
              if(a == null)
                a = prev;
              b = root;
          }
               
          prev = root;
          recoverTree_(root.right);
          }
      }
      
      
}
