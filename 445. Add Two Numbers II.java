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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1 == null || l2 == null)
        {
            if(l1 == null)
                return l2;
            else
                return l1;
        }
        
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);
        
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        
        while(r1 != null || r2 != null || carry != 0)
        {
            int sum = carry;
            if(r1 != null)
            {
                sum += r1.val;
                r1 = r1.next;
            }
            if(r2 != null)
            {
                sum += r2.val;
                r2 = r2.next;
            }
            
            dummy.next = new ListNode(sum%10);
            carry = sum/10;
            dummy = dummy.next;
        }
        
        return reverse(head.next);
    }
    
    ListNode reverse(ListNode node)
    {
        if(node == null || node.next == null)
            return node;
        
        ListNode prev = null;
        ListNode forw = null;
        ListNode curr = node;
        
        while(curr != null)
        {
            forw = curr.next;
            
            curr.next = prev;
            prev = curr;
            
            curr = forw;
        }
        return prev;
    }
}
