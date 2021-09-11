class Solution {
    
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> st = new Stack<>();
        
        for(int i : asteroids)
        {
           if(i > 0)
           {
               st.push(i);
           }
            else // for negative vals
            {
                while(st.size() > 0 && st.peek() > 0 && st.peek() < Math.abs(i))
                {
                    st.pop();
                }
                
                if(st.size() > 0 && st.peek() == Math.abs(i))
                {
                    st.pop();
                }
                else if(st.size() > 0 && st.peek() > Math.abs(i))
                {
                    continue;
                }
                else
                {
                    st.push(i);
                }
            }
        }
        
        int res[] = new int[st.size()];
        for(int i = res.length - 1; i >= 0; i--)
            res[i] = st.pop();
        return res;
        
    }
}
