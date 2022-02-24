class Solution {
    public String largestNumber(int[] arr) {
        
        String[] nums = new String[arr.length];

        for(int i = 0; i < nums.length; i++)
            nums[i] = arr[i] + "";
        
        StringBuilder sb = new StringBuilder();
        
        Arrays.sort(nums, (a,b) ->{
            long d1 = Long.parseLong(a+b);
            long d2 = Long.parseLong(b+a);
            if(d1 > d2)
                return 1;
            return -1;
        });
        
        for(int i = nums.length-1; i >= 0; i--)
        {
            sb.append(nums[i]);
        }
        if(sb.charAt(0) == '0')
            return "0";
        return sb.toString();
    }
}
