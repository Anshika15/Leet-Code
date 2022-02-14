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
    public int[] findMode(TreeNode root) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0)
        {
            TreeNode rem = q.removeFirst();
            if(rem.left != null)
                q.add(rem.left);
            if(rem.right != null)
                q.add(rem.right);
            map.put(rem.val, map.getOrDefault(rem.val, 0)+1);
            maxFreq = Math.max(maxFreq, map.get(rem.val));
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int key : map.keySet())
        {
            if(map.get(key) == maxFreq)
                list.add(key);
        }
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            arr[i] = list.get(i);
        return arr;
    }
}
