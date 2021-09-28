class Solution {
    public int nextGreaterElement(int n) {
        
        char arr[] = (n+"").toCharArray();

        int i = arr.length-2;
        while(i >= 0 && arr[i] >= arr[i+1])
            i--;
        if(i == -1)
            return -1;
        
        int k = arr.length-1;
        
        while(k >= 0 && arr[i] >= arr[k])
            k--;
        // swap i and k
        if(k == -1)
            return -1;
        char temp = arr[k];
        arr[k] = arr[i];
        arr[i] = temp;
        
        StringBuilder sb = new StringBuilder();
        
        for(int j = 0; j <= i; j++)
            sb.append(arr[j]);
        
        for(int j = arr.length-1; j > i; j--)
            sb.append(arr[j]);
        
        
        try{
            int res = Integer.parseInt(sb.toString());
            return res;
        }
        catch(Exception e)
        {
            
        }
        
        return -1;
            
        
    }
}
