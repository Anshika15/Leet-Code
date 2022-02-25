class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        
        for(char ch : s.toCharArray())
        {
            if(ch == '#')
            {
                if(st1.size() > 0)
                    st1.pop();
            }
                
            else
                st1.push(ch);
        }
        
        for(char ch : t.toCharArray())
        {
            if(ch == '#')
            {
                if(st2.size() > 0)
                    st2.pop();
            }
            else
                st2.push(ch);
        }
        
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        while(st1.size() > 0)
            sb1.append(st1.pop());
        
         while(st2.size() > 0)
            sb2.append(st2.pop());
        
        String s1 = sb1.toString();
        String s2 = sb2.toString();
        return s1.equals(s2);
    }
}
