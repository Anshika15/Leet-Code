class Solution {
    public int trap(int[] height) {
        
        int size = height.length;
        if(size == 0)
            return 0;
        
        int maxl[] = new int[size];
        int maxr[] = new int[size];
        
        maxl[0] = height[0];
        for(int i = 1; i < size; i++)
        {
            maxl[i] = Math.max(maxl[i-1], height[i]);
        }
        
        maxr[size-1] = height[size-1];
        for(int i = size-2; i >= 0; i--)
        {
            maxr[i] = Math.max(maxr[i+1], height[i]);
        }
        
        int sum = 0;
        int water[] = new int[size];
        for(int i = 0; i < size; i++)
        {
            water[i] = (Math.min(maxr[i] , maxl[i]) - height[i]);
            sum += water[i];
        }
        
        for(int i = 0; i < size; i++)
        {
            System.out.print(maxl[i] + " ");
        }
        System.out.println();
        
        for(int i = 0; i < size; i++)
        {
            System.out.print(maxr[i] + " ");
        }
        System.out.println();
        
        for(int i = 0; i < size; i++)
        {
            System.out.print(water[i] + " ");
        }
        System.out.println();
        
        return sum;
        
    }
}
