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
    Queue<Integer> list = new LinkedList<>(); 
    public TreeNode increasingBST(TreeNode root) {
        
        inorder(root);
        
        root = null;
        if(root == null)
        {
            root = new TreeNode(list.poll());
        }
        TreeNode temp = root;
        while(list.size() != 0)
        {
            temp.right = new TreeNode(list.poll());
            temp = temp.right;
        }
        return root;
        
    }
    public void inorder(TreeNode root)
    {
        if(root != null)
        {
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }
}
