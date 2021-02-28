class Solution {
    public int divide(int dividend, int divisor) {
        
        if(dividend == 0)
            return 0;
        
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == 1)
            return Integer.MIN_VALUE;
        if(dividend == Integer.MAX_VALUE && divisor == -1)
            return Integer.MIN_VALUE;
        if(dividend == Integer.MAX_VALUE && divisor == 1)
            return Integer.MAX_VALUE;
        
        
      
        int res = 0;
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        
        while(a-b >= 0)
        {
            int x = 0;
            while((a- (b << 1 << x)) >= 0 )
            {
                x++;
            }
            res += 1 << x;
            a -= b << x;
        }
        return (dividend >= 0) == (divisor >= 0) ? res : -res;
        
    }
}
