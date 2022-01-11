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
    
    ArrayList<String> list = new ArrayList<>();
    public int sumRootToLeaf(TreeNode root) {
        
        
        sumRootToLeaf_(root, "");
        System.out.println(list);
        int res = 0;
        for(String val : list)
        res += Integer.parseInt(val,2);
        return res;
        
    }
    
    public void sumRootToLeaf_(TreeNode root, String psf)
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
        {
            list.add(psf + root.val);
        }
        sumRootToLeaf_(root.left, psf + root.val);
        sumRootToLeaf_(root.right, psf + root.val);
        
    }
    
}
