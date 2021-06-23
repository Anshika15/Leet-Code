/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        copyList(head);
        copyRandomPointers(head);
        return extractDeepCopy(head);
    }
    
    public void copyList(Node head){
        
        Node curr = head;
        
        while(curr != null)
        {
            Node forw = curr.next;
            Node node = new Node(curr.val);
            
            curr.next = node;
            node.next = forw;
            
            curr = forw;
            
        }
    }
    
    public void copyRandomPointers(Node head){
        
        Node curr = head;
        while(curr != null)
        {
            Node ran = curr.random;
            if(ran != null)
            {
                curr.next.random = ran.next;
            }
            curr = curr.next.next;
        }
        
    }
    
    public Node extractDeepCopy(Node head)
    {
        Node dummy = new Node(-1);
        Node prev = dummy;
        Node curr = head;
        
        while(curr != null)
        {
            prev.next = curr.next;
            curr.next = curr.next.next;
            
            prev = prev.next;
            curr = curr.next;
        }
        
        return dummy.next;
    }
}