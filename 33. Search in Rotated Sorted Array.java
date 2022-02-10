class Solution {
    public int search(int[] arr, int target) {
        
        int i = 0;
        int j = arr.length-1;

        while(i <= j)
        {
            int mid = i + (j-i)/2;
            if(arr[mid] == target)
                return mid;
            if(arr[i] <= arr[mid])
            {
                // checking low to mid part is sorted
                if(target >= arr[i] && target < arr[mid])
                {
                    // then our value lies in this range only so search here
                    j = mid-1;
                }
                else
                {
                    i = mid+1;
                }
            }
            else if(arr[mid] <= arr[j]) // check whether mid to high part is sorted or not
            {
                if(target >= arr[mid] && target <= arr[j])
                {
                    // then our value lies in this range only so search here
                    i = mid+1;
                }
                else
                {
                    j = mid-1;
                }
            }

        }

        return -1;
        
    }
}
