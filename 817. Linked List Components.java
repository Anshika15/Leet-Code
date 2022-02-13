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
    public int numComponents(ListNode head, int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int val : nums)
            set.add(val);
        ListNode curr = head;
        int count = 0;
        while(curr != null)
        {
            if(set.contains(curr.val) && (curr.next == null || !set.contains(curr.next.val)))
                count++;
            curr = curr.next;
        }
        return count;
        
    }
}
