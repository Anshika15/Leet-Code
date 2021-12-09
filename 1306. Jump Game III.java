class Solution {
    public boolean canReach(int[] arr, int start) {
        
       if(start >= 0 && start < arr.length)
       {
           if(arr[start] == 0)
               return true;
           if(arr[start] < 0)
               return false;
           arr[start] = -arr[start];
           return canReach(arr, start+arr[start]) || canReach(arr, start-arr[start]);
       }
        return false;
        
    }
}
