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
    public int getDecimalValue(ListNode head) {
        
        ListNode nhead = reverse(head);
        
        ListNode curr = nhead;
        int res = 0;
        int power = 0;
        
        while(curr != null)
        {
            res = res + (int)(curr.val * Math.pow(2, power));
            power++;
            curr = curr.next;
        }
        return res;
        
    }
    
    ListNode reverse(ListNode head)
    {
        if(head != null)
        {
            ListNode prev = null;
            ListNode curr = head;
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
        return null;
    }
}
