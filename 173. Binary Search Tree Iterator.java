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
class BSTIterator {

    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
      st = new Stack<>();
      addAllLeft(root);
    }

    void addAllLeft(TreeNode node)
    {
      while(node != null)
      {
        st.push(node);
        node = node.left;
      }
    }

    public int next() {

      TreeNode topNode = st.pop();
      addAllLeft(topNode.right);
      return topNode.val;

    }

    public boolean hasNext() {
      return st.size() != 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
