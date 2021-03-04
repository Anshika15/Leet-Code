/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int a = len(headA);
        int b = len(headB);
        while(a > b)
        {
            headA = headA.next;
            a--;
        }
        while(b > a)
        {
            headB = headB.next;
            b--;
        }
        while(headA != headB)
        {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
        
    }
    
    int len(ListNode temp)
    {
        int l = 0;
        while(temp != null)
        {
            l++;
            temp = temp.next;
        }
        return l;
    }
}
