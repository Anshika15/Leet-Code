class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer str1 = new StringBuffer();
        StringBuffer str2 = new StringBuffer();
        for(int i = 0; i < word1.length; i++)
            str1.append(word1[i]);
        for(int i = 0; i < word2.length; i++)
            str2.append(word2[i]);
        
        if(str1.toString().equals(str2.toString()))
            return true;
        return false;
    }
}
