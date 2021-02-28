class FreqStack {
    
    class Pair{
        int val;
        int freq;
        int time;
        
        Pair(int v, int f, int t)
        {
            val = v;
            freq = f;
            time = t;
        }
    }
    
    int init = 0;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.freq == b.freq ? Integer.compare(b.time, a.time) :                                                                                            Integer.compare(b.freq, a.freq));

    public FreqStack() {
        
        
    }
    
    public void push(int x) {
        
        int f = map.getOrDefault(x,0) + 1;
        map.put(x, f);
        pq.add(new Pair(x, f, init++));
       // init++;
        
    }
    
    public int pop() {
        Pair p = pq.poll();
       // System.out.println(p.val + " " + p.freq + " " + p.time);
        if(p.freq == 1)
            map.remove(p.val);
        else
            map.put(p.val, p.freq - 1);
        return p.val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
