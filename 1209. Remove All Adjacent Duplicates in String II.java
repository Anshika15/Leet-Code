class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<Pair> st = new Stack<>();
        st.push(new Pair('#', 0));
        
        for(char c : s.toCharArray())
        {
            Pair p = st.peek();
            if(p.ch == c)
            {
                p.count++;
                if(p.count == k)
                    st.pop();
            }
            else
            {
                st.push(new Pair(c,1));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < st.size(); i++){
            int count = st.get(i).count;
            while(count-- > 0)
            {
                sb.append(st.get(i).ch);
            }
        }
        return sb.toString();
        
    }
    
    class Pair{
        char ch;
        int count;
        Pair(char ch, int count)
        {
            this.ch = ch;
            this.count = count;
        }
    }
}
