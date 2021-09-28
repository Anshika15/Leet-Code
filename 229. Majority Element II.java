class Solution {
    public List<Integer> majorityElement(int[] arr) {
        
        int count1 = 1;
        int val1 = arr[0];
        
        int count2 = 0;
        int val2 = arr[0];
        
        for(int i = 1; i < arr.length; i++)
        {
            if(val1 == arr[i])
                count1++;
            else if(val2 == arr[i])
                count2++;
            else
            {
                if(count1 == 0)
                {
                    val1 = arr[i];
                    count1++;
                }
                else if(count2 == 0)
                {
                    val2 = arr[i];
                    count2++;
                }
                else
                {
                    count1--;
                    count2--;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        if(isSolution(val1, arr))
        {
            res.add(val1);
        }
        
        if(val1 != val2 && isSolution(val2, arr))
        {
            res.add(val2);
        }
        
        return res;
        
    }
    
    public boolean isSolution(int val , int[] arr)
    {
        int c = 0;
        for(int ele: arr)
        {
            if(ele == val)
                c++;
        }
        
        return c > arr.length/3;
    }
}
