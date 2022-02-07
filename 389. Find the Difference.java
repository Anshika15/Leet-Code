class Solution {
    public char findTheDifference(String s, String t) {
        
        int val = 0;
        for(char ch : t.toCharArray())
        {
            val += (int)ch;
        }
        
        for(char ch : s.toCharArray())
        {
            val = val - (int)ch;
        }
        System.out.println(val);
        return (char)val;
        
    }
}
