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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        ListNode anode = null;
        ListNode bnode = null;
        
        ListNode temp = list1;

        int i = 0;
        while(temp != null)
        {
            if(i == a-1)
            {
                anode = temp;
            }
            if(i == b+1)
            {
                bnode = temp;
            }
            temp = temp.next;
            i++;
        }
        if(anode != null)
        anode.next = list2;
        
        temp = list2;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = bnode;
        return list1;
        
    }
}
