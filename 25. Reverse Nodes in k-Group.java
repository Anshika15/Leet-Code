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
    
    ListNode th = null;
    ListNode tt = null;
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || head.next == null || k == 0)
            return head;
        
        int len = length(head);
        ListNode curr = head;
        ListNode oh = null;
        ListNode ot = null;
        
        while(len >= k)
        {
            int tempK = k;
            while(tempK -- > 0)
            {
                ListNode forw = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = forw;
            }
            
            if(oh == null && ot == null)
            {
                oh = th;
                ot = tt;
            }
            else
            {
                ot.next = th;
                ot = tt;
            }
            th = null;
            tt = null;
            len -= k;
        }
        ot.next = curr;
        return oh;
    }
    
    public void addFirst(ListNode node)
    {
      if(th == null && tt == null)
      {
          th = node;
          tt = node;
      }
        else
        {
            node.next = th;
            th = node;
        }
    }
    
    public int length(ListNode head)
    {
        int l = 0;
        ListNode curr = head;
        while(curr != null)
        {
            l++;
            curr = curr.next;
        }
        return l;
    }
}
