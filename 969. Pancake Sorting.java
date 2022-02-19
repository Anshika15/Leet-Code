class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        
        List<Integer> res = new ArrayList<>();
        
        // find max element from leftover array
        
        // take the max element to 0 the postion by using panckae sorting
        
        // take the element to its original position by using pancake sorting
        
        for(int i = arr.length - 1; i >= 0; i--)
        {
            int maxIdx = i;
            for(int j = i-1; j >= 0; j--)
            {
                if(arr[maxIdx] < arr[j])
                {
                    maxIdx = j;
                }
            }
            
            if(maxIdx != i)
            {
                reverse(arr, 0, maxIdx);
                res.add(maxIdx+1);
                
                reverse(arr, 0, i);
                res.add(i+1);
            }
        }
        return res;
        
    }
    
    public void reverse(int[] arr, int start, int end)
    {
        while(start < end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
