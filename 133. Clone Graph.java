/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
     HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        
       if (node == null) return null;                    // If node is null, return null

        if (map.containsKey(node))                    // If node is already visited, 
            return map.get(node);                        /// return the clone of it, by getting it from map

        Node clone = new Node(node.val, new ArrayList()); // Create the clone of the current node
        map.put(node, clone);                         // Add the item in the visited map

        for (Node n : node.neighbors)                     // For each neighbor of current node
            clone.neighbors.add(cloneGraph(n));              /// Recursively clone and get the node, and add it as neighbor

        return clone;                                     // Return the cloned current node
    }
}
