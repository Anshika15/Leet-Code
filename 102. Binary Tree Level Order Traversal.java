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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
       
        while(!q.isEmpty())
        {
            ArrayList<Integer> l = new ArrayList<>();
            int level = q.size();
            for(int i = 0; i < level; i++)
            {
               if(q.peek().left != null)
                    q.add(q.peek().left);
               if(q.peek().right != null)
                    q.add(q.peek().right); 
                l.add(q.poll().val);
            }
            list.add(l);
            
        }
        return list;
    }
}
