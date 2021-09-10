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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new LinkedList<>();
        if(root == null)
            return res;
        LinkedList<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        int k = -1;
        while(q.size() > 0)
        {
            int size = q.size();
            k++;
            LinkedList<Integer> l = new LinkedList<>();
            while(size-- > 0)
            {
                TreeNode rem = q.remove();
                l.add(rem.val);
                
                if(rem.left != null)
                {
                    q.add(rem.left);
                }
                if(rem.right != null)
                {
                    q.add(rem.right);
                }
            }
            if(k % 2 != 0)
            {
                 Collections.reverse(l);
            }
            res.add(l);
        }
        
        return res;
        
    }
}
