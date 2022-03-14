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
    public int maxLevelSum(TreeNode root) {
        
        int l = 1;
        int max = root.val;
        
        int level = 0;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0)
        {
            int size = q.size();
            level++;
            int sum = 0;
            while(size-- > 0)
            {
                TreeNode rem = q.removeFirst();
                sum += rem.val;
                if(rem.left != null)
                    q.add(rem.left);
                if(rem.right != null)
                    q.add(rem.right);
            }
            //System.out.println(sum);
            if(sum > max)
            {
                max = sum;
                l = level;
            }
        }
        return l;
    }
}
