class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(numRows <= 0)
            return result;
        
        for(int i = 0; i < numRows; i++)
        {
            List<Integer> smallRes = new ArrayList<>();
            
            for(int j = 0; j <= i; j++)
            {
                if(j == 0 || j == i)
                    smallRes.add(1);
                else
                    smallRes.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
            }
            
            result.add(new ArrayList<>(smallRes));
        }
        
        return result;
        
    }
}
