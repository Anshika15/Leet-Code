class Solution {
    public String breakPalindrome(String palindrome) {
        
        if(palindrome.length() <= 1)
            return "";
        
        char ch[] = palindrome.toCharArray();
        for(int i = 0; i  < palindrome.length()/2; i++)
        {
            if(palindrome.charAt(i) != 'a')
            {
                ch[i] = 'a';
                return String.valueOf(ch);
            }
        }
        
        ch[palindrome.length() - 1] = 'b';
        
        return String.valueOf(ch);
            
        
    }
}
