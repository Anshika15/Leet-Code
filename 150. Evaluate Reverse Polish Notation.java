class Solution {
    
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        
        for(String str: tokens)
        {
            if(str.equals("+"))
            {
                int f1 = stack.pop();
                int f2 = stack.pop();
                stack.push(f1+f2);
            }
            else if(str.equals("-"))
            {
                int f1 = stack.pop();
                int f2 = stack.pop();
                stack.push(f2 - f1);
            }
            else if(str.equals("/"))
            {
                int f1 = stack.pop();
                int f2 = stack.pop();
                stack.push(f2/f1);
            }
            else if(str.equals("*"))
            {
                int f1 = stack.pop();
                int f2 = stack.pop();
                stack.push(f1*f2);
            }
           else
           {
               stack.add(Integer.parseInt(str));
           }
        }
        
        return stack.pop();
    }
}
