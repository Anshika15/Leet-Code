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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode curr = head;
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode otail = odd;
        ListNode etail = even;
        
        int i = 1;
        while(curr != null)
        {
            if(i % 2 != 0)
            {
                otail.next = curr;
                otail = otail.next;
            }
            else 
            {
                etail.next = curr;
                etail = etail.next;
            }
            curr = curr.next;
            i++;
            
        }
        
        etail.next = null;
        otail.next = null;
        otail.next = even.next;
        return odd.next;
        
    }
}
