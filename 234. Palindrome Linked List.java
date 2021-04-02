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
    public boolean isPalindrome(ListNode head) {
        
        StringBuffer sb = new StringBuffer();
        ListNode temp = head;
        while(temp != null)
        {
            sb.append(temp.val);
            temp = temp.next;
        }
        System.out.println(sb.toString());
        String s1 = sb.toString();
        String s2 = sb.reverse().toString();
        System.out.println(s1 + " " + s2);
        return s1.equals(s2);
    }
}
