class StockSpanner {
    
    int i = -1;
    Stack<Pair> stack = new Stack<>();
    ArrayList<Integer> res = new ArrayList<Integer>();
    class Pair{
        int ngl;
        int index;
        Pair(int ngl, int index)
        {
            this.ngl = ngl;
            this.index = index;
        }
    }

    public StockSpanner() {
        
    }
    
    public int next(int price) {
        i++;
        
        if(stack.size() == 0)
        {
            res.add(-1);
        }
        
        else if(stack.size() > 0 && stack.peek().ngl > price)
        {
            res.add(stack.peek().index);
        }
        
        else if(stack.size() > 0 && stack.peek().ngl <= price)
        {
            while(stack.size() > 0 && stack.peek().ngl <= price)
                stack.pop();
            if(stack.size() == 0)
                res.add(-1);
            else
                res.add(stack.peek().index);
        }
        
        stack.push(new Pair(price, i));
        res.set(i, i - res.get(i));
        return res.get(i);
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
