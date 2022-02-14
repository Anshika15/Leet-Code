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
    int maxFreq = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        solve(root, map);

        ArrayList<Integer> l = new ArrayList<>();
        for(int key : map.keySet())
        {
            if(map.get(key) == maxFreq)
            {
                l.add(key);
            }
        }
        int[] arr = new int[l.size()];
        for(int i = 0; i < l.size(); i++)
            arr[i] = l.get(i);
        return arr;
    }
    
    int solve(TreeNode root, HashMap<Integer, Integer> map)
    {
        if(root == null)
            return 0;
        int sum = solve(root.left, map) + solve(root.right, map) + root.val;
        map.put(sum, map.getOrDefault(sum,0)+1);
        maxFreq = Math.max(maxFreq, map.get(sum));
        return sum;
    }
}
