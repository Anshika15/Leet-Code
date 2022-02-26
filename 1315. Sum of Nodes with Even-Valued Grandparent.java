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
    public int sumEvenGrandparent(TreeNode root) {
        
        if(root == null)
            return 0;
        
        int sum = 0;
        
        LinkedList<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root, null, null));
        
        while(q.size() > 0)
        {
            int size = q.size();
            while(size-- > 0)
            {
                Pair rem = q.removeFirst();
                if(rem.grandParent != null && rem.grandParent.val % 2 == 0)
                {
                    sum += rem.node.val;
                }
                if(rem.node.left != null)
                {
                    q.add(new Pair(rem.node.left, rem.node, rem.parent));
                }
                if(rem.node.right != null)
                {
                    q.add(new Pair(rem.node.right, rem.node, rem.parent));
                }
            }
        }
        
        return sum;
        
    }
    
    class Pair{
        TreeNode node;
        TreeNode parent;
        TreeNode grandParent;
        
        Pair(){}
        
        Pair(TreeNode node, TreeNode parent, TreeNode grandParent)
        {
            this.node = node;
            this.parent = parent;
            this.grandParent = grandParent;
        }
    }
}
