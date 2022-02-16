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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        
        int len = size(head);
        
        if(k == len || k == 0)
            return head;
        if(k > len)
            k = k%len;
        ListNode curr = head;
        ListNode tail = null;

        while(curr.next != null){
            curr = curr.next;   
        }
        tail = curr;
        tail.next = head;
        curr = head;

        for(int i = 0; i < len-k; i++)
        {
           
            tail = tail.next;
        }
        ListNode nhead  = tail.next;
        tail.next = null;
        return nhead;
    }
    
    int size(ListNode node)
    {
        if(node == null)
            return 0;
        ListNode curr = node;
        int count = 0;
        while(curr != null)
        {
            count++;
            curr = curr.next;
        }
        return count;
    }
}
