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
    public ListNode removeZeroSumSublists(ListNode head) {
        
        HashMap<Integer, ListNode> map = new HashMap<>();
        
        ListNode temp = new ListNode(0); // added zero for those prefix sum whose sum is zero
        temp.next = head;
        int sum = 0;
        ListNode curr = temp; 
        /* calcualte for all prefix sum till current node*/
        while(curr != null)
        {
            sum += curr.val;
            map.put(sum, curr);
            curr = curr.next;
        }
        
        /* As hashmap doesn't support duplicates keys therefore, nodes with same prefix sum would have been changed and if our current node and node with prefix sum doesn't match then the sum in between these nodes including later is zero. therefore remove/skip these nodes.*/
        curr = temp;
        sum = 0;
        while(curr != null)
        {
            sum += curr.val;
            curr.next = map.get(sum).next;
            curr = curr.next;
        }
       return temp.next; 
    }
}
