class Solution {
    public String reverseOnlyLetters(String s) {
        
        int start = 0;
        int end = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        
        while(start < end)
        {
            char ch1 = s.charAt(start);
            char ch2 = s.charAt(end);
            
            if(!Character.isLetter(ch1)) 
            {
                start++;
            }
            else if(!Character.isLetter(ch2))
            {
                end--;
            }
            else
            {
                sb.setCharAt(start, ch2);
                sb.setCharAt(end, ch1);
                start++;
                end--;
            }
        }
        
        return sb.toString();
    }
}
