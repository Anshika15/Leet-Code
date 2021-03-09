class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() == 0)
            return 0;
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
                stack.add(i);
            else if(s.charAt(i) == ')'){
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '(')
                    stack.pop();
                else
                    stack.add(i);
            }
        }
       // System.out.println(stack);
        if(stack.isEmpty())
            return s.length();
        int s1 = s.length(), s2 = 0;
        int res = 0;
        while(!stack.isEmpty())
        {
            s2 = stack.pop();
            res = Math.max(res, s1-s2-1);
            s1 = s2;
           // System.out.println(s2 + " " + s1);
        }
        res = Math.max(res, s1);
        return res;
    }
}
