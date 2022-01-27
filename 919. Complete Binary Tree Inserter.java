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
class CBTInserter {
    
    TreeNode head = null;
    TreeNode nextInsertionPointer = null;
    LinkedList<TreeNode> q;
    public CBTInserter(TreeNode root) {
        
        head = root;
        q = new LinkedList<>();
        q.add(root);
        while(true)
        {
            TreeNode node = q.getFirst();
            if(node.left != null)
            {
                q.add(node.left);
            }
            else
            {
                nextInsertionPointer = node;
                break;
            }
            
            if(node.right != null)
            {
                q.add(node.right);
            }
            else
            {
                nextInsertionPointer = node;
                break;
            }
            q.removeFirst();
        }
        
    }
    
    public int insert(int val) {
        int res = nextInsertionPointer.val;
        if(nextInsertionPointer.left == null)
        {
            TreeNode node = new TreeNode(val);
            nextInsertionPointer.left = node;
            q.add(node);
        }
        else
        {
            TreeNode node = new TreeNode(val);
            nextInsertionPointer.right = node;
            q.removeFirst();
            q.add(node);
            nextInsertionPointer = q.getFirst();
            
        }
        return res;
    }
    
    public TreeNode get_root() {
        return head;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
