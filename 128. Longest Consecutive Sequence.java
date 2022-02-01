class Solution {
    public int longestConsecutive(int[] arr) {
        
    HashMap<Integer, Boolean> map = new HashMap<>();
    int n = arr.length;
    for(int i = 0; i < n; i++)
    {
        map.put(arr[i], true);
    }

    for(int i = 0; i < n; i++)
    {
        if(map.containsKey(arr[i]-1))
        {
            map.put(arr[i], false);
        }
    }

    int maxLen = 0;
    int start = 0;
    for(int val : arr)
    {
        if(map.get(val))
        {
            int len = 1;

            while(map.containsKey(val + len))
                len++;
            if(len > maxLen)
            {
                maxLen = len;
                start = val;
            }
        }
    }

    return maxLen;
        
    }
}
