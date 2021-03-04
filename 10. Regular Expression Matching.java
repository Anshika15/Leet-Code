class Solution {
    public boolean isMatch(String s, String p) {
        
        if(s == null || p == null)
            return false;
        
        int strlen = s.length();
        int patlen = p.length();
        if(strlen == 0 && patlen == 0)
            return true;
        
        boolean t[][] = new boolean[strlen+1][patlen+1];
        t[0][0] = true;
        for(int j = 2; j <= patlen; j++)
        {
            if(p.charAt(j-1) == '*' && t[0][j-2])
                t[0][j] = true;
        }
        
        for(int i = 1; i <= strlen; i++)
        {
            for(int j = 1; j <= patlen; j++)
            {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
                    t[i][j] = t[i-1][j-1];
                if(p.charAt(j-1) == '*')
                {
                    boolean b1 = t[i][j-2];
                    boolean b2 = false;
                    if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.')
                        b2 = t[i-1][j];
                    t[i][j] = b1 || b2;
                        
                }
            }
        }
        
        return t[strlen][patlen];
        
    }
}
