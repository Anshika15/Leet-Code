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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> res1 = new ArrayList<>();
        getLeafNodes(root1, res1);
        ArrayList<Integer> res2 = new ArrayList<>();
        getLeafNodes(root2, res2);

        return res1.equals(res2);
    }

    void getLeafNodes(TreeNode root, ArrayList<Integer> res)
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            res.add(root.val);
        getLeafNodes(root.left, res);
        getLeafNodes(root.right, res);
    }
}
