class Solution {
    public boolean halvesAreAlike(String s) {
        
        s = s.toLowerCase();
        
        int c1 = 0, c2 = 0;
        for(int i = 0; i < s.length() / 2; i++)
        {
            if(isVowel(s.charAt(i)))
                c1++;
        }
        for(int i = s.length() / 2 ; i < s.length(); i++)
        {
            if(isVowel(s.charAt(i)))
                c2++;
        }
        
        if(c1 == c2)
            return true;
        return false;
        
    }
    
    public boolean isVowel(char ch)
    {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        return false;
    }
}
