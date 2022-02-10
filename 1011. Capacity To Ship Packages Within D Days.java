class Solution {
    public int shipWithinDays(int[] weights, int days) {
            int sum = 0;
            int max = 0;

            for(int i = 0; i < weights.length; i++)
            {
              sum += weights[i];
              max = Math.max(weights[i], max);
            }

            if(weights.length == days)
              return max;

            int lo = max;
            int hi = sum;
            int ans = 0;

            while(lo <= hi)
            {
              int mid = lo + (hi-lo)/2;

              if(isPossible(mid, weights, days))
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

          public boolean isPossible(int capacity, int[] arr, int days)
          {
            int sd = 1;
            int sum = 0;
            for(int i = 0; i < arr.length; i++)
            {
              sum += arr[i];
              if(sum > capacity)
              {
                sd++;
                sum = arr[i];
              }
            }
            return sd <= days;
          }

}
