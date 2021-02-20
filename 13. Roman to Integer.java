class Solution {
    
    int val(char c)
    {
        int v = -1;
        switch(c)
        {
            case 'I':
                v = 1;
                break;
            case 'V':
                v = 5;
                break;
            case 'X':
                v = 10;
                break;
            case 'L':
                v = 50;
                break;
            case 'C':
                v = 100;
                break;
            case 'D':
                v = 500;
                break;
            case 'M':
                v = 1000;
                break;      
        }
        return v;
    }
    
    public int romanToInt(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++)
        {
            int res1 = val(s.charAt(i));
            if(i + 1 < s.length())
            {
                int res2 = val(s.charAt(i+1));
                if(res1 >= res2)
                {
                    res += res1;
                }
                else if(res2 > res1)
                {
                    res += res2 - res1;
                    i++;
                }
            }
            else
            {
                res += res1;
            }
        }
        
        return res;  
    }
}
