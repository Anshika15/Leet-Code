class Solution {
    public void wiggleSort(int[] nums) {
        
        Arrays.sort(nums);
        
        int[] res = new int[nums.length];
        
        int i = 1;
        int j = nums.length-1;
        
        while(i < nums.length)
        {
            res[i] = nums[j];
            i += 2;
            j--;
        }
        
        i = 0;
        while(i < nums.length)
        {
            res[i] = nums[j];
            i+= 2;
            j--;
        }
        
        for(i = 0; i < nums.length; i++)
            nums[i] = res[i];
    }
}
