class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int lo = 0;
        int hi = Integer.MIN_VALUE;
        
        for(int val : piles)
        {
            hi = Math.max(hi, val);
        }
        
        if(piles.length == h)
            return hi;
        
        int speed = Integer.MAX_VALUE;
        
        while(lo <= hi)
        {
            int sp = lo + (hi-lo)/2;
            if(isPossible(piles, sp, h))
            {
                speed = sp;
                hi = sp-1;
            }
            else
            {
                lo = sp+1;
            }
        }
        return speed;
        
    }
    
    public boolean isPossible(int[] piles, int speed, int h)
    {
        int time = 0;
        for(int i = 0; i < piles.length; i++)
        {
            time += (int)Math.ceil(piles[i]*1.0/speed);
        }
        return time <= h;
    }
}
