class Solution {
     class Trie{
      
      class Node{
          Node left, right;
      }
      Node root;
      Trie(){
          root = new Node();
      }
      
      public void insert(int val)
      {
          int bitIdx = 30;
          Node curr = root;
          while(bitIdx >= 0)
          {
              int mask = 1<<bitIdx; // 2^bitIdx
              int bit = (mask&val) > 0 ? 1 : 0;
              if(bit == 0)
              {
                if(curr.left == null)
                    curr.left = new Node();
                curr = curr.left;
              }
              else
              {
                if(curr.right == null)
                    curr.right = new Node();
                curr = curr.right;  
              }
              bitIdx--;
          }
      }
      
      public int query(int find)
      {
         int bitIdx = 30;
         Node curr = root;
         int ans = 0;
         while(bitIdx >= 0)
         {
             int mask = 1<<bitIdx; // 2^bitIdx
             int bit = (mask&find) > 0 ? 1 : 0;
             if(bit == 0)
             {
               if(curr.left != null)
                   curr = curr.left;
               else
                {
                    curr = curr.right;
                    ans |= mask;
                }
             }
             else
             {
               if(curr.right != null){
                  curr = curr.right; 
                  ans |= mask;
               }
               else
               {
                   curr = curr.left;
               }
             }
             bitIdx--;  
         }
         return ans;
      }
  }
    
  public int findMaximumXOR(int[] nums) {
    
    Trie trie = new Trie();
  
    for(int val : nums)
    {
        trie.insert(val);
    }
    
    int max = 0;
    for(int val : nums)
    {
        int find = Integer.MAX_VALUE ^ val;
        int res = trie.query(find);
        max = Math.max(max, res^val);
    }
    return max;
  }
}
