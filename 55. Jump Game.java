class Solution {
    public boolean canJump(int[] arr) {
        
        int reach = 0;
        int i = 0;
        for(i = 0; i < arr.length && i <= reach; i++)
        {
            reach = Math.max(i+arr[i], reach);
          
            System.out.println(reach);
        }
        
        return i == arr.length;
        
    }
}
