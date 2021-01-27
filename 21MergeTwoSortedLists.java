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
    
    ListNode l;
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        ListNode temp = l1;
        while(temp != null)
        {
            list.add(temp.val);
            temp = temp.next;
        }
        temp = l2;
        while(temp != null)
        {
            list.add(temp.val);
            temp = temp.next;
        }
        
        Collections.sort(list);
        
        for(int i = 0; i < list.size(); i++)
            add(list.get(i));
        
        return l;
        
    }
    
    public void add(int value)
    {
        
      if(l == null)
	  {
	    l = new ListNode(value); // first node is created.
	  }
	  else
	   {
	     ListNode Last = l;
	     while(Last.next != null)	
	      {
	    	 Last = Last.next;
	    	 }
	     Last.next = new ListNode(value);
	   }
       /* if(l == null)
        {
            l = new ListNode(value);
        }
        else
        {
        ListNode temp = l;
        while(temp != null)
        {
            temp = temp.next;
        }
        temp.next = new ListNode(value);
        }*/
    }
}
