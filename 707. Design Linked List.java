class MyLinkedList {
    
    class Node{
        int data;
        Node next;
        
        Node(){}
        
        Node(int val)
        {
            this.data = val;
        }
        Node(int val, Node next)
        {
            this.data = val;
            this.next = next;
        }
    }
    
    Node head;
    int size;
    Node tail;
    
    public MyLinkedList() {
        
       head = null;
        size = 0;
        tail = head;
    }
    
    public int get(int index) {
        if(index < 0 || index >= size)
        {
            return -1;
        }
        
        Node temp = head;
        while(index-- > 0)
        {
            temp = temp.next;
        }
        return temp.data;
    }
    
    public void addAtHead(int val) {
        if(head == null)
        {
            Node node = new Node(val);
            head = tail = node;
            size++;
            return;
        }
        else
        {
            Node node = new Node(val);
            node.next = head;
            head = node;
            size++;
            return;
        }
        
    }
    
    public void addAtTail(int val) {
        if(head == null)
        {
             Node node = new Node(val);
             head = tail = node;
             size++;
             return;
        }
        else
        {
            tail.next = new Node(val);
            tail = tail.next;
            size++;
            return;
        }
    }
    
    public void addAtIndex(int idx, int val) {
        
       if(idx < 0 || idx > size)
       {
         return;
       }
       else if(size == idx)
       {
         addAtTail(val);
       }
       else if(idx == 0)
       {
         addAtHead(val);
       }
       else{
         Node node = new Node(val);
         Node temp = head;

         for(int i = 0; i < idx-1; i++)
         {
           temp = temp.next;
         }
         node.next = temp.next;
         temp.next = node;
         size++;
         return;
       }
        
    }
    
    public void removeLast() {
      if (size == 0) {
        System.out.println("List is empty");
      } else if (size == 1) {
        head = tail = null;
        size = 0;
      } else {
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
          temp = temp.next;
        }

        tail = temp;
        tail.next = null;
        size--;
      }
    }
     
    public void removeFirst() {
      if (size == 0) {
        System.out.println("List is empty");
      } else if (size == 1) {
        head = tail = null;
        size = 0;
      } else {
        head = head.next;
        size--;
      }
    }
    
    public void deleteAtIndex(int idx) {
        
     if (idx < 0 || idx >= size) {
        return;
      } 
      else if(size == 0)
      {
        System.out.println("List is empty");
         return;
      }
      else if (idx == 0) {
        removeFirst();
      } else if (idx == size-1) {
        removeLast();
      } else {
        
        Node temp = head;
        for (int i = 0; i < idx - 1; i++) {
          temp = temp.next;
        }
        temp.next = temp.next.next;;
        size--;
      }
        
    }
    
    public void print()
    {
        Node node = head;
        while(node != null)
        {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println();
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
