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

class Pair{
    TreeNode node;
    TreeNode parent;
    int level;
    Pair(TreeNode node, TreeNode parent, int level)
    {
        this.node = node;
        this.parent = parent;
        this.level = level;
    }
}
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        LinkedList<Pair> q = new LinkedList<>();
        
        Pair x1 = null;
        Pair y1 = null;
        q.add(new Pair(root, null, 0));
        while(q.size() > 0)
        {
            int size = q.size();
            while(size-- > 0)
            {
                Pair rem = q.removeFirst();
                
                if(rem.node.val == x)
                    x1 = rem;
                if(rem.node.val == y)
                    y1 = rem;
                
                if(rem.node.left != null)
                    q.add(new Pair(rem.node.left, rem.node, rem.level+1));
                if(rem.node.right != null)
                    q.add(new Pair(rem.node.right, rem.node, rem.level+1));
            }
        }
        
        if(x1 != null && y1 != null && x1.level == y1.level && x1.parent != y1.parent)
            return true;
        return false;
        
    }
}
