/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    List<TreeNode> path;
    List<Integer> res;
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        path = new ArrayList<>();
        res = new ArrayList<>();
        find(root, target);
        
        for(int i = 0; i < path.size(); i++)
        {
            kdistance(path.get(i), k-i, i == 0 ? null : path.get(i-1));
        }
        
        return res;
    }
    
    public void kdistance(TreeNode root, int k, TreeNode blocker)
    {
        if(k < 0 || root == null || root == blocker)
            return;
        if(k == 0)
            res.add(root.val);
        kdistance(root.left, k-1, blocker);
        kdistance(root.right, k-1, blocker);
        
    }
    
    public boolean find(TreeNode root, TreeNode target)
    {
        if(root == null)
            return false;
        if(target.val == root.val)
        {
            path.add(root);
            return true;
        }
        if(find(root.left, target))
        {
           path.add(root);
            return true; 
        }
        if(find(root.right, target))
        {
           path.add(root);
            return true; 
        }
        return false;
    }
}
