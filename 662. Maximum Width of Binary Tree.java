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
    
    class Pair{
        int i;
        TreeNode node;
        Pair(TreeNode node, int i)
        {
            this.node = node;
            this.i = i;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        
        int res = 0;
        LinkedList<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(q.size() > 0)
        {
            int size = q.size();
            int lm = q.getFirst().i;
            int rm = q.getFirst().i;
            while(size-- > 0)
            {
                Pair rem = q.removeFirst();
                rm = rem.i;
                
                if(rem.node.left != null)
                {
                    q.add(new Pair(rem.node.left, rem.i*2+1));
                }
                if(rem.node.right != null)
                {
                    q.add(new Pair(rem.node.right, rem.i*2+2));
                }
                
            }
            
            res = Math.max(res, rm-lm+1);
        }
        return res;
        
    }
}
