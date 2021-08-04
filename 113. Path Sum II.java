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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // list.add(root);
        dfs(root, targetSum, l, list);
        return l;
        
    }
    
    public void dfs(TreeNode root, int sum, List<List<Integer>> l, List<Integer> list)
    {
        if(root != null)
        {
            list.add(root.val);
            if(root.left == null && root.right == null && root.val == sum)
            {
                l.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                return;
            }
            
            else{
            
            if(root.left != null) dfs(root.left, sum - root.val, l, list);
            if(root.right != null) dfs(root.right, sum - root.val, l, list);
                
            }
            
            list.remove(list.size() - 1);
        }
        
        else
        {
            return;
        }
    }
}