class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        for(char ch : s.toCharArray())
        {
            if(Character.isLetter(ch) || Character.isDigit(ch))
                sb.append(ch);
        }
        
        String st = sb.toString();
        //System.out.println(st);
        String st2 = sb.reverse().toString();
        //System.out.println(st2);
        return st.equals(st2);
        
    }
}
