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
    
    public void serialize_(TreeNode root, StringBuilder sb)
    {
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");
        serialize_(root.left, sb);
        serialize_(root.right, sb);
        
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       /* if(root == null)
            return ""; */
        StringBuilder sb = new StringBuilder();
        serialize_(root, sb);
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    int idx = 0;
    public TreeNode deserialize(String data) {
        
        String[] arr = data.split(",");
        return deserialize_(arr);
        
    }
    
    public TreeNode deserialize_(String[] arr)
    {
        if(idx >= arr.length || arr[idx].equals("null"))
        {
            idx++;
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
        node.left = deserialize_(arr);
        node.right = deserialize_(arr);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
