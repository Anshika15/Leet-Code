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
    public boolean isEvenOddTree(TreeNode root) {
        
        if(root == null)
            return true;
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(q.size() > 0)
        {
            int size = q.size();
            int val = 0;
            while(size-- > 0)
            {
                TreeNode rem = q.removeFirst();
                if(level%2 == 0) // check odd vals in strictly increasing
                {
                    if(rem.val%2 == 0)
                        return false;
                    
                    if(val != 0)
                    {
                        if(val >= rem.val)
                            return false;
                        val = rem.val;
                    }
                    else
                    {
                        val = rem.val;
                    }
                }
                else // check even vals in strictly decreasing
                {
                    if(rem.val%2 != 0)
                        return false;
                    
                    if(val != 0)
                    {
                        if(val <= rem.val)
                            return false;
                        val = rem.val;
                    }
                    else
                    {
                        val = rem.val;
                    }
                }
                
                if(rem.left != null)
                    q.add(rem.left);
                if(rem.right != null)
                    q.add(rem.right);
            }
            level++;
        }
        
        return true;
    }
}
