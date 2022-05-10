class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        
        solution(result, new ArrayList<>(), k, n, 1);
        
        return result;
    }
    
    void solution(List<List<Integer>> result, List<Integer> smallRes, int k, int n, int start)
    {
        if(n < 0)
            return;
        
        if(smallRes.size() == k && n == 0)
        {
            result.add(new ArrayList<>(smallRes));
            return;
        }
        
        for(int idx = start; idx<= 9; idx++)
        {
            smallRes.add(idx);
            solution(result, smallRes, k, n-idx, idx+1);
            smallRes.remove(smallRes.size() - 1);
        }
        
    }
}
