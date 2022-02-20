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
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null)
            return head;
        
        ListNode mid = middle(head);
        ListNode nhead = null;
        if(mid != null){
         nhead = mid.next;
         mid.next = null;
        }
        
        ListNode fnode = sortList(head);
        ListNode snode = sortList(nhead);
        
        return merge(fnode, snode);
    }
    
    ListNode middle(ListNode node)
    {
        if(node == null || node.next == null)
            return node;
        ListNode fast = node;
        ListNode slow = node;
        while(fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    ListNode merge(ListNode node1, ListNode node2)
    {
        if(node1 == null)
            return node2;
        if(node2 == null)
            return node1;
        ListNode head = new ListNode(-1);
        ListNode prev = head;
        while(node1 != null && node2 != null)
        {
            if(node1.val > node2.val)
            {
                prev.next = node2;
                node2 = node2.next;
                prev = prev.next;
            }
            else
            {
                prev.next = node1;
                node1 = node1.next;
                prev = prev.next;  
            }
        }
        
        if(node2 != null)
        {
            prev.next = node2;
        }
        else
        {
            prev.next = node1;
        }
        return head.next;
    }
}
