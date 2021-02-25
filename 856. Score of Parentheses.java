class Solution {
    public int scoreOfParentheses(String S) {
        
        int c = 0;
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0; i < S.length(); i++)
        {
            if(S.charAt(i) == '(')
            {
                s.add(c);
                c = 0;
            }
            else if(S.charAt(i) == ')')
            {
               c = s.pop() + Math.max(2*c, 1);
            }
                
        }
        return c;
        
    }
}
