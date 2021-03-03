class Solution {
    
    List<List<Integer>> list  = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      //  list  = new ArrayList<ArrayList<Integer>>();
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
                res.add(arr[i]);
                solve(arr, res, targetLeft - arr[i], i);
                res.remove(res.size() - 1);
            }
        }
    }
}
