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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> res = new LinkedList<>();
        if(root == null)
            return res;
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        
        while(q.size() > 0)
        {
            LinkedList<Integer> l = new LinkedList<>();
            int size = q.size();
            while(size-- > 0)
            {
                TreeNode rem = q.removeFirst();
                l.add(rem.val);
                if(rem.left != null)
                    q.addLast(rem.left);
                if(rem.right != null)
                    q.addLast(rem.right);
            }
            
            res.add(0, l);
        }
        return res;
        
        
    }
}
