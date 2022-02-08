class MyQueue {

    Stack<Integer> myst;
    Stack<Integer> helpst;
    
    public MyQueue() {
        myst = new Stack<>();
        helpst = new Stack<>();
    }
    
    public void push(int x) {
        while(myst.size() > 0)
        {
            helpst.push(myst.pop());
        }
        
        myst.push(x);
        
        while(helpst.size() > 0)
        {
            myst.push(helpst.pop());
        }
    }
    
    public int pop() {
        
        if(myst.size() == 0)
            return -1;
        return myst.pop();
        
    }
    
    public int peek() {
         if(myst.size() == 0)
            return -1;
        return myst.peek();
    }
    
    public boolean empty() {
        if(myst.size() == 0)
            return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
