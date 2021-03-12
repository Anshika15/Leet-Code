class Solution {
    public int findJudge(int N, int[][] trust) {
        
        int c[] = new int[N+1];
        
        for(int i = 0; i < trust.length; i++)
        {
            c[trust[i][0]]--;
            c[trust[i][1]]++;
        }
        for(int i = 1; i <= N; i++)
            if(c[i] == N-1)
                return i;
        return -1;
    }
}
