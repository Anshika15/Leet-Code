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
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        
        List<Integer> res = new ArrayList<>();
        if(root1 == null && root2 == null)
            return res;
        
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        
        inorder(root1, l1);
        inorder(root2, l2);
        
        if(root1 == null)
            return l2;
        if(root2 == null)
            return l1;
        
        res.addAll(l1);
        res.addAll(l2);
        Collections .sort(res);
      
        return res;
        
    }
    
    public void inorder(TreeNode root, List<Integer> l)
    {
        if(root != null)
        {
            inorder(root.left, l);
            l.add(root.val);
            inorder(root.right, l);
        }
    }
    
    
}
