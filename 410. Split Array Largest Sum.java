class Solution {
    public int splitArray(int[] arr, int m) {
            int sum = 0;
            int max = 0;
            for(int i = 0; i < arr.length; i++)
            {
              sum += arr[i];
              max = Math.max(arr[i], max);
            }

            if(arr.length == m)
              return max;

            int lo = max;
            int hi = sum;
            int ans = 0;
            while(lo <= hi)
            {
              int mid = lo + (hi - lo)/2;

              if(isPossible(mid, arr, m))
              {
                ans = mid;
                hi = mid-1;
              }
              else
              {
                lo = mid+1;
              }
            }
            return ans;
          }


          public boolean isPossible(int distributions, int[] arr, int minReq)
          {
            int sa = 1;
            int sum = 0;
            for(int i = 0; i < arr.length; i++)
            {
              sum += arr[i];

              if(sum > distributions)
              {
                sa++;
                sum = arr[i];
              }
            }
            return sa <= minReq;
          }
}
