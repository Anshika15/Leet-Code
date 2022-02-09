class Solution {
    public int numRabbits(int[] answers) {
        
        int res = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < answers.length; i++)
        {
            map.put(answers[i], map.getOrDefault(answers[i], 0)+1);
        }
        
        for(int val : map.keySet())
        {
            int groupSize = val+1; // group size = number of similar rabbit s with me i.e = similar rabbit + 1 (for me)
           
           int reportees = map.get(val);
           
           int numOfGropus = (int)Math.ceil(reportees * 1.0 / groupSize * 1.0) * groupSize; 
           
           res += numOfGropus;
        }
        
        return res;
        
    }
}
