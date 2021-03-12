class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet<>();
        if(s.length() < k)
            return false;
        for(int i = 0; i <= s.length()-k; i++)
        {
            set.add(s.substring(i, i+k));
        }
        if(set.size() == Math.pow(2, k))
            return true;
        return false;
    }
}
