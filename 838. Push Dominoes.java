class Solution {
    public String pushDominoes(String str) {
        
        int n = str.length();
        char[] arr = new char[n+2];
        arr[0] = 'L';
        arr[n+1] = 'R';

        for(int i = 1; i < arr.length-1; i++)
        {
            arr[i] = str.charAt(i-1);
        }

        int j = 0;
        int k = 1;
        while(k < arr.length)
        {
            while(arr[k] == '.')
                k++;
            if(k-j > 1)
                solveConfiguration(j, k, arr);
            j = k;
            k++;
        }
        // our ans is present in 1 to n idx
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < arr.length-1; i++)
            sb.append(arr[i] + "");

        return sb.toString();

    }
    
    public void solveConfiguration(int i, int j, char[] arr)
    {
      if(arr[i] == 'L' && arr[j] == 'L')
      {
        // make all dots L  
        for(int k = i+1; k < j; k++)
            arr[k] = 'L';
      }
      else if(arr[i] == 'L' && arr[j] == 'R')
      {
         // nothing to do 
      }
      else if(arr[i] == 'R' && arr[j] == 'R')
      {
          // make all dots R
          for(int k = i+1; k < j; k++)
            arr[k] = 'R';
      }
      else
      {
         // solve acc to even and odd count
         if((j-i-1)%2 == 0)
         {
             // even
             int mid = (i+j)/2;
             // i+1 to mid => R
             // mid+1 to j => L
             for(int k = i+1; k <= mid; k++)
             {
                 arr[k] = 'R';
             }
             for(int k = mid+1; k < j; k++)
             {
                 arr[k] = 'L';
             }
         }
         else
         {
             // odd
             int mid = (i+j)/2;
             // i+1 to mid-1 => R
             // mid+1 to j => L
             for(int k = i+1; k < mid; k++)
             {
                 arr[k] = 'R';
             }
             for(int k = mid+1; k < j; k++)
             {
                 arr[k] = 'L';
             }
         }
      }
     }
}
