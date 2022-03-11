class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        List<String> res = new ArrayList<>();
        if(s.length() < 10)
            return res;
        
        HashSet<String> set = new HashSet<>();
        HashSet<String> resultSet = new HashSet<>();
        int i = 0;
        int j = 10;
        while(j <= s.length())
        {
            String str = s.substring(i, j);
            if(set.contains(str)) // repeated
            {
                resultSet.add(str);
            }
            i++;
            j++;
            set.add(str);
        }
        
        return new ArrayList<>(resultSet);
    }
}
