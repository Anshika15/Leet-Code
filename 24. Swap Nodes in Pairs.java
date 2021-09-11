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
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null)
            return head;
        
       ListNode dummy = new ListNode(-1);
       ListNode point = dummy;
       point.next = head;
        
        while(point.next != null && point.next.next != null)
        {
            ListNode firstNode = point.next;
            ListNode secondNode = point.next.next;

            firstNode.next = secondNode.next;
          
            secondNode.next = firstNode;
            
            point.next = secondNode;
            point = firstNode;
        }
        
        return dummy.next;
        
    }
}
