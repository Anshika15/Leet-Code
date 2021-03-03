class Solution {
    
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        solve(candidates, new ArrayList(), target, 0);
        return list;
        
    }
    
    public void solve(int[] arr, ArrayList<Integer> res, int targetLeft, int start)
    {
        if(targetLeft == 0)
        {
            list.add(new ArrayList<>(res));
            return;
        }
        else if(targetLeft < 0)
            return;
        
        else
        {
            for(int i = start; i < arr.length; i++)
            {
                if(i > start && arr[i] == arr[i-1])
                    continue;
                res.add(arr[i]);
                solve(arr, res, targetLeft - arr[i], i+1);
                res.remove(res.size() - 1);
            }
        }
    }
    
}
