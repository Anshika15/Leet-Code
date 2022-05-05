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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        
        StringBuilder st = new StringBuilder();
        StringBuilder end = new StringBuilder();
        find(root, startValue, st);
        find(root, destValue, end);
        
        int i = 0; int j = 0;
        st = st.reverse();
        end = end.reverse();
        
        while(i < st.length() && j < end.length() && st.charAt(i) == end.charAt(j))
        {
            i++;
            j++;
        }
        
        String s1 = st.substring(i);
        String s2 = end.substring(j);
        
        String res = "U".repeat(s1.length());
        res += s2;
        return res;
        
    }
    
    boolean find(TreeNode root, int val, StringBuilder psf)
    {
        if(root == null)
            return false;
      
        if(root.val == val)
            return true;
        if(root.left != null && find(root.left, val, psf))
        {
            psf.append("L");
            return true;
        }
        else if(root.right != null && find(root.right, val, psf))
        {
            psf.append("R");
            return true;
        }
        return false;
            
    }
}
