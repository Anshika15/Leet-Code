class Solution {
    public boolean isValid(String s) {
         Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++)
        {
           
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            else if(stack.isEmpty())
                return false;
            else if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}')
            {
                char st = s.charAt(i);
                
                char c = stack.pop();
                if(c == '(' && st == ')')
                    continue;
                else if(c == '[' && st == ']')
                    continue;
                else if(c == '{' && st == '}')
                    continue;
                else
                    return false;
 
            }
 
        }
        
       // System.out.println(stack);
        if(stack.isEmpty())
            return true;
        return false;
    }
}
