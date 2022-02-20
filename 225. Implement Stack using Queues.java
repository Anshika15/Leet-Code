class MyStack {

    Queue<Integer> mainQ; 
    Queue<Integer> helperQ;
    public MyStack() {
        
        mainQ = new ArrayDeque<>();
        helperQ = new ArrayDeque<>();
    }
    
    public void push(int x) {
        
     while(mainQ.size() > 0)
      {
          helperQ.add(mainQ.remove());
      }
      mainQ.add(x);
      while(helperQ.size() > 0)
      {
          mainQ.add(helperQ.remove());
      }
        
    }
    
    public int pop() {
        return mainQ.remove();
    }
    
    public int top() {
        return mainQ.peek();
    }
    
    public boolean empty() {
        return mainQ.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
