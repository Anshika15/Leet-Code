class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        Arrays.sort(arr);
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < arr.length-1; i++)
        {
           min = Math.min(Math.abs(arr[i] - arr[i+1]), min); 
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < arr.length-1; i++)
        {
           if(min == Math.abs(arr[i] - arr[i+1]))
           {
              ArrayList<Integer> l = new ArrayList<>();
               l.add(arr[i]);
               l.add(arr[i+1]);
               res.add(l);
           }
        }
        return res;
        
    }
}
