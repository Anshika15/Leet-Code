class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int s = triangle.size();
        int t[] = new int[s+1];
        
        for(int i = s-1; i >= 0; i--)
        {
            for(int j = 0; j < triangle.get(i).size(); j++)
            {
                t[j] = Math.min(t[j], t[j+1]) + triangle.get(i).get(j);
              // System.out.println(t[j]);
            }
        }
        return t[0];
    }
}
