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
    double sum = 0;
    double c = 0;
    List<Double> list = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        
        int h = height(root);
        System.out.println(h);
        for(int i = 1; i <= h; i++){
            sum = 0;
            c = 0;
            level(root, i);
            sum = sum/c;
            list.add(sum);
        }
            
        return list;
    }
    
    int height(TreeNode root)
    {
        if(root != null)
        {
            int l = height(root.left);
            int r = height(root.right);
            if(l > r)
                return l+1;
            return r+1;
        }
        return 0;
    }
    
    void level(TreeNode root, int i)
    {
        if(root != null){
        if(i == 1)
        {   sum += root.val;
            c++;
           // System.out.println(sum);
        }
        else
        {
            level(root.left, i-1);
            level(root.right, i-1);
        }
        }
    }
}
