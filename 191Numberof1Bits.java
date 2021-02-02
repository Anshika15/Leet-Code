public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
       int c = 0;
       for(int i = 1; i < 33; i++)
        {
            if((n & (1 << i)) != 0)
            {
                c++;
               // System.out.println(c);
            }
        }
        return c;
        
    }
}
