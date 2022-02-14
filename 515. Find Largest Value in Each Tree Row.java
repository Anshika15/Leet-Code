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
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(q.size() > 0)
        {
            int size = q.size();
            int max = q.peek().val;
            while(size-- > 0)
            {
                TreeNode rem = q.removeFirst();
                max = Math.max(max, rem.val);
                
                if(rem.left != null)
                    q.add(rem.left);
                if(rem.right != null)
                    q.add(rem.right);
                
            }
            res.add(max);
        }
        
        return res;
    }
}
