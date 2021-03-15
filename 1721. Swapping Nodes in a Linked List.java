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
    ListNode node = null;
    public ListNode swapNodes(ListNode head, int k) {
        
       k = k-1;
        ListNode tempf = head;
        while(k > 0)
        {
            tempf = tempf.next;
            k--;
        }
        
        ListNode templ = head;
        ListNode temp = tempf;
        while(temp.next != null)
        {
            templ = templ.next;
            temp = temp.next;
        }
        
        int v = templ.val;
        templ.val = tempf.val;
        tempf.val = v;
        return head;
    }
}
