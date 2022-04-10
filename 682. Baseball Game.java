class Solution {
    public int calPoints(String[] ops) {
        
        Stack<Integer> st = new Stack<>();
        
        for(String str : ops)
        {
            if(str.equals("+"))
            {
                int val1 = st.pop();
                int val2 = st.peek();
                st.push(val1);
                st.push(val2 + val1);
            }
            else if(str.equals("D"))
            {
                int val = st.peek();
                st.push(2*val);
            }
            else if(str.equals("C"))
            {
                st.pop();
            }
            else
            {
                // new score
                st.push(Integer.parseInt(str));
            }
        }
        
        
        int result = 0;
        
        while(st.size() > 0)
        {
            result += st.pop();
        }
        
        return result;
    }
}
