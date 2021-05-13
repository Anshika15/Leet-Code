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
    
    HashMap<Integer, Integer> map = new HashMap<>();
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i = 0; i < inorder.length; i++)
        {
            map.put(inorder[i], i); // value, index in map
        }
        
        return convert(preorder, 0, preorder.length-1);
    }
    
    public TreeNode convert(int[] pre, int start, int end)
    {
        if(start > end)
            return null;
        int val = pre[index];
        TreeNode root = new TreeNode(val);
        index++;
        
        root.left = convert(pre, start, map.get(val) - 1);
        root.right = convert(pre, map.get(val)+1, end);
        return root;
    }
}
