class Solution {
    public int searchInsert(int[] arr, int target) {
        
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
        int mid = start + (end-start)/2;
        if(arr[mid] == target)
            return mid;
        else if(arr[mid] > target)
            end = mid-1;
        else start = mid+1;
       
        }
        return start;
        
    }
}
