class Solution {
    int matches = 0;
    public int numberOfMatches(int n) {
       
        int r = rec(n);
        return matches;
            
    }
    
    public int rec(int n)
    {
        if(n == 2)
        {
             matches += 1;
             return 0; 
        }
        if(n == 1 || n == 0)
            return 0;
        if(n % 2 == 0)
        {
            matches += n/2;
            return rec(n/2);
        }
        if(n % 2 != 0)
        {
            matches += (n-1)/2;
            return rec((n-1)/2+1);
        }
        return 0;
    }
}
