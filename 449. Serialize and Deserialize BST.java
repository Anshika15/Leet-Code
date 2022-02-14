/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
        serialize_(root, sb);
        return sb.toString();
        
    }
    
    void serialize_(TreeNode root, StringBuilder sb)
    {
        if(root == null)
        {
            sb.append("null,");
            return;
        }
        sb.append(root.val +",");
        serialize_(root.left, sb);
        serialize_(root.right, sb);
    }

    // Decodes your encoded data to tree.
    
    int idx;
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        idx = 0;
        return deserialize_(arr);
    }
    
    TreeNode deserialize_(String[] data)
    {
        if(idx >= data.length || data[idx].equals("null")){
            idx++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(data[idx++]));
        node.left = deserialize_(data);
        node.right = deserialize_(data);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
