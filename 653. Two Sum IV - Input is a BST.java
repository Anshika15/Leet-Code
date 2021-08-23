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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        inorder(list, root);
        int l = 0;
        int r = list.size() - 1;
        while(l < r)
        {
            if(list.get(l) + list.get(r) > k)
            {
                r--;
            }
            else if(list.get(l) + list.get(r) < k)
            {
                l++;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
    
    public static void inorder(ArrayList<Integer> l, TreeNode root)
    {
        if(root != null)
        {
            inorder(l, root.left);
            l.add(root.val);
            inorder(l, root.right);
        }
    }
}
