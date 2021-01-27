class Solution {
    public int kthGrammar(int N, int K) {
        
        if(N == 1 && K == 1)
        {
            return 0;
        }
        int mid = (int) Math.pow(2, N-1)/2;
        if(K <= mid)
            return kthGrammar(N-1, K);
        else
        {
            int res = kthGrammar(N-1, K - mid);
            if(res == 1)
                return 0;
            else
                return 1;
        }
        
    }
}
