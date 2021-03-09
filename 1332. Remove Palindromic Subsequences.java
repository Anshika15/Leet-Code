class Solution {
    public int removePalindromeSub(String s) {
        
        if(s.length() == 0)
            return 0;
        StringBuffer sb = new StringBuffer(s);
        sb = sb.reverse();
        if(s.equals(sb.toString()))
        {
            return 1;
        }
        
        return 2;
    }
}
