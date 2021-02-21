class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> extraStack = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int x) {
        
        stack.add(x);
        if(extraStack.size() == 0 || extraStack.peek() >= x)
            extraStack.add(x);
        
    }
    
    public void pop() {
        
        if(stack.size() == 0)
            return;
        int ans = stack.peek();
        stack.remove(stack.size() - 1);
        if(ans == extraStack.peek())
            extraStack.remove(extraStack.size() - 1);
        
    }
    
    public int top() {
        
        return stack.peek();
    }
    
    public int getMin() {
        
        if(extraStack.size() == 0)
            return -1;
        return extraStack.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
