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
    public int findBottomLeftValue(TreeNode root) {
        if(root == null)
            return -1;
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = root.val;
        while(q.size() > 0)
        {
            int size = q.size();
            res = q.peek().val;
            while(size-- > 0)
            {
                TreeNode rem = q.removeFirst();
                if(rem.left != null)
                    q.add(rem.left);
                
                if(rem.right != null)
                    q.add(rem.right);
            }
        }
        return res;
        
    }
}
