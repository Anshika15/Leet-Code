class Solution {
    public List<Integer> lexicalOrder(int n) {
        
        List<Integer> res = new ArrayList<>();
        
        for(int i = 1; i <= 9; i++)
        {
            dfs(i, n, res);
        }
        return res;
    }
    
    public void dfs(int i, int n, List<Integer> res)
    {
        if(i > n)
            return;
        res.add(i);
        for(int j = 0; j <= 9; j++)
            dfs(10*i + j, n, res);
    }
}
