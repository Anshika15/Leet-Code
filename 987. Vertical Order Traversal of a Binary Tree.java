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
    class Pair implements Comparable<Pair>{
        TreeNode node;
        int hl;
        Pair(TreeNode node, int hl)
        {
            this.node = node;
            this.hl = hl;
        }
        
        public int compareTo(Pair p)
        {
            return this.node.val - p.node.val;
        }
        
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        int[] width = new int[2];
        findWidth(root, 0, width);
        int len = width[1] - width[0] + 1;
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < len; i++)
        {
            res.add(new ArrayList<>());
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        PriorityQueue<Pair> cq = new PriorityQueue<>();
        pq.add(new Pair(root, Math.abs(width[0])));
        
        while(pq.size() > 0)
        {
            int size = pq.size();
            while(size-- > 0 )
            {
                Pair rem = pq.remove();
                res.get(rem.hl).add(rem.node.val);
                
                if(rem.node.left != null)
                {
                    cq.add(new Pair(rem.node.left, rem.hl-1));
                }
                
                if(rem.node.right != null)
                {
                    cq.add(new Pair(rem.node.right, rem.hl+1));
                }
                
            }
            
            PriorityQueue<Pair> temp = pq;
            pq = cq;
            cq = temp;
        }
        return res;
    }
    
    public void findWidth(TreeNode root, int hl, int[] ans)
    {
        if(root == null)
            return;
        ans[0] = Math.min(hl, ans[0]);
        ans[1] = Math.max(hl, ans[1]);
        
        findWidth(root.left, hl-1, ans);
        findWidth(root.right, hl+1, ans);
    }
}
