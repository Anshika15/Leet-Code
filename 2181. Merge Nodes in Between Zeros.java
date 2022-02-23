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
    public ListNode mergeNodes(ListNode head) {
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        int sum = 0;
        ListNode curr = head;
        
        while(curr != null)
        {
            if(curr.val == 0 && sum != 0)
            {
                prev.next = new ListNode(sum);
                prev = prev.next;
                sum = 0;
            }
            sum += curr.val;
            curr = curr.next;
        }
        return dummy.next;
    }
}
