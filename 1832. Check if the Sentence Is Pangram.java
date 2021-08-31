class Solution {
    public boolean checkIfPangram(String sentence) {
        
        HashSet<Character> set = new HashSet<>();
        for(char ch: sentence.toCharArray())
        {
            set.add(ch);
        }
        
        if(set.size() == 26)
            return true;
        return false;
    }
}
