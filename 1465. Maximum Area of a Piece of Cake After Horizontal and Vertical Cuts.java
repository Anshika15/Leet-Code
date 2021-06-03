class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        int mod = 1000000007;

        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        
        int m1 = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        int m2 = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        
        for(int i = 0; i < horizontalCuts.length - 1; i++)
        {
            m1 = Math.max(m1, horizontalCuts[i+1]-horizontalCuts[i]);
        }
       
        
        for(int i = 0; i < verticalCuts.length - 1; i++)
        {
           m2 = Math.max(m2, verticalCuts[i+1]-verticalCuts[i]);
        }
        
       
        return (int)((long)m2*m1 % mod);
            
        
    }
}
