class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int count = 0;
        for(int i = 0; i < flowerbed.length && count < n; i++)
        {
            if(flowerbed[i] == 0)
            {
                int next = 0;
                if(i !=  flowerbed.length-1)
                {
                    next = flowerbed[i+1];
                }
                
                int prev = 0;
                if(i !=  0)
                {
                    prev = flowerbed[i-1];
                }
                
                if(next == 0 && prev == 0){
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        
        return count == n;
    }
}
