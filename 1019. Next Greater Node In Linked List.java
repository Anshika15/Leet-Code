/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    int size = 0;
    int length(ListNode head)
    {
        ListNode curr = head;
        int c = 0;
        
        while(curr != null)
        {
            c++;
            curr = curr.next;
        }
        
        return c;
    }
    
    ListNode reverse(ListNode node)
    {
         if(node == null || node.next == null)
            return node;

          ListNode curr = node;
          ListNode prev = null;
          ListNode forw = null;

          while(curr != null)
          {
              forw = curr.next;
              curr.next = prev;

              prev = curr;
              curr = forw;

          }

         
        return prev;
    }
    
    public int[] nextLargerNodes(ListNode head) {
        if(head == null)
            return new int[0];
        
        ListNode node = reverse(head);
        int n = length(node);

        int[] res = new int[n];
        res[n-1] = 0;
        
        Stack<Integer> st = new Stack<>();
        st.push(node.val);
        node = node.next;
        
        for(int i = n-2; i >= 0 && node != null; i--)
        {
            int val = node.val;
            while(st.size() > 0 && val >= st.peek())
                st.pop();
            if(st.size() == 0)
                res[i] = 0;
            else
                res[i] = st.peek();
            node = node.next;
            st.push(val);
        }
        return res;
        
    }
}
