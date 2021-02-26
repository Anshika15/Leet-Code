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
        
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode head = new ListNode(0);
        ListNode temp = head; 
        
        int num = 0;
        
        while(l1 != null || l2 != null || num != 0)
        {
            
            if(l1 != null)
            {
                num += l1.val;
                System.out.println(num);
                l1 = l1.next;
            }
            if(l2 != null)
            {
                num += l2.val;
                System.out.println(num);
                l2 = l2.next;
            }
            
            temp.next = new ListNode(num % 10);
            temp = temp.next;
            num /= 10;
        }
        return head.next;
        
    }
}
