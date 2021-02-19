class Solution {
    
    Stack<Integer> stack = new Stack<>();
    public String minRemoveToMakeValid(String s) {
        StringBuilder str = new StringBuilder(s);
        for(int i = 0; i < s.length(); i++)
        {
            if(str.charAt(i) == '(')
                stack.push(i);
            else if(str.charAt(i) == ')')
            {
                if(!stack.isEmpty())
                {
                    stack.pop();
                }
                else
                    str.setCharAt(i, '*');
            }
               
        }
        
        while(!stack.isEmpty())
        {
            int i = stack.pop();
            str.setCharAt(i, '*');
        }
        
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i) != '*')
                sb.append(str.charAt(i));     
        }
        
        return sb.toString();
    }
}
