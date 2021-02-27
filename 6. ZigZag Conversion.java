class Solution {
    public String convert(String s, int numRows) {
        
     //   int i = 0; j = 0;
        
        StringBuffer sb[] = new StringBuffer[numRows];
        
        for(int q = 0; q < sb.length; q++)
        {
            sb[q] = new StringBuffer();
        }
        
        
        int j = 0;
        while(j < s.length())
        {
            for(int i = 0; i < numRows && j < s.length(); i++)
            {
                sb[i].append(s.charAt(j));
                j++;
            }
            
            for(int i = numRows-2; i >= 1 && j < s.length(); i--)
            {
                sb[i].append(s.charAt(j));
                j++;
            }
        }
        StringBuffer res = new StringBuffer();
        for(int i = 0; i < sb.length; i++)
            res.append(sb[i]);
        return res.toString();
    }
}
