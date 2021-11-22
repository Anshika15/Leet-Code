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
    public TreeNode deleteNode(TreeNode node, int data) {
    
    if(node == null)
        return null;
    else if(data > node.val)
    {
        node.right = deleteNode(node.right, data);
    }
    else if(data < node.val)
    {
        node.left = deleteNode(node.left, data);
    }
    else
    {
        if(node.left != null && node.right != null)
        {
            int lmax = max(node.left);
            node.val = lmax;
            node.left = deleteNode(node.left, lmax);
        }
        else if(node.left != null)
        {
           return node.left;
        }
        else if(node.right != null)
        {
            return node.right;
        }
        else
        {
            return null;
        }
    }
    return node;
  }
  
  public int max(TreeNode node)
  {
      if(node.right != null)
        return max(node.right);
    
      return node.val;
      
      
  }
}
