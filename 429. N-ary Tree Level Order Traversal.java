/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        LinkedList<Node> q = new LinkedList<>();
        
        List<List<Integer>> list = new LinkedList<>();
        
        if(root != null){
        
        q.add(root);
        
        while(q.size() > 0)
        {
            int size = q.size();
            List<Integer> l = new LinkedList<>();
            while(size-- > 0)
            {
               Node rem = q.removeFirst();
               l.add(rem.val);
               for(Node child : rem.children)
                {
                   if(child != null)
                    q.add(child);
                }
            }
            list.add(l);
        }
        
        return list;
        }
        return list;
        
    }
}