class Solution {
    public int countPrimes(int n) {
        
        if(n == 0 || n == 1)
            return 0;
        boolean primes[] = new boolean[n];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        int count = 0;
        
        for(int i = 2; i*i < n; i++) /* O(log(log(n))) */
        {
           if(primes[i] == true){
            /* make factors of i false */
            for(int j = i+i; j < n; j+= i)  /* O(n) */
            {
                primes[j] = false; // not prime
            }
           }
          }
        
        for(int i = 0; i < n; i++)
        {
            if(primes[i])
                count++;
        }
        return count;
    }
}
