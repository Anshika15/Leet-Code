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

    int size = 0;
    ListNode node;
    public Solution(ListNode head) {
        size = getSize(head);
        node = head;
    }
    
    int getSize(ListNode head)
    {
        if(head == null)
            return 0;
        ListNode temp = head;
        int c = 0;
        while(temp != null)
        {
            c++;
            temp = temp.next;
        }
        return c;
    }
    
    public int getRandom() {
        
       int i = (int)(Math.random() * this.size);
        ListNode temp = this.node;
        while(i > 0)
        {
            temp = temp.next;
            i--;
        } 
       return temp.val;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
