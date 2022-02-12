class Solution {
    public int[][] merge(int[][] intervals) {
        
        Pair[] pairs = new Pair[intervals.length];
        for(int i = 0; i < intervals.length; i++)
        {
            pairs[i] = new Pair(intervals[i][0], intervals[i][1]);
        }

        Arrays.sort(pairs);


        Stack<Pair> st = new Stack<>();
        for(int i = 0; i < pairs.length; i++)
        {
            if(i == 0)
            {
                st.push(pairs[i]);
            }
            else
            {
                Pair top = st.peek();
                if(pairs[i].start > top.end)
                {
                    st.push(pairs[i]);
                }
                else{
                    top.end = Math.max(top.end, pairs[i].end);
                }
            }
        }

        Stack<Pair> res = new Stack<>();
        while(st.size() > 0)
        {
            res.push(st.pop());
        }
        
        int[][] arr = new int[res.size()][2];
        int i = 0;
        while(res.size() > 0)
        {
            Pair p = res.pop();
            arr[i][0] = p.start;
            arr[i][1] = p.end;
            i++;
        }
        return arr;
        
    }
    
    class Pair implements Comparable<Pair>{
        int start;
        int end;
        Pair(){}
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int compareTo(Pair p)
        {
            return this.start - p.start;
        }
    }
}
