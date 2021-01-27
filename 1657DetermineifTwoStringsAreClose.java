class Solution {
    
    /*
    Two strings are close:
    1. Have the same length, ccabbb => 6 == aabccc => 6
    2. Have the same char set, ccabbb => (a, b, c) == aabccc => (a, b, c)
    3. Have the same sorted char counts ccabbb => (1, 2, 3) == aabccc => (1, 2, 3)
    
    */
    public boolean closeStrings(String word1, String word2) {
        
        ArrayList<Character> list1 = new ArrayList<Character>();
        ArrayList<Character> list2 = new ArrayList<Character>();
        
        for(int i = 0; i < word1.length(); i++)
        {
            list1.add(word1.charAt(i));
        }
        
        for(int i = 0; i < word2.length(); i++)
        {
            list2.add(word2.charAt(i));
        }
        
        
        TreeSet<Character> set1 = new TreeSet<Character>(list1);  // whether the words contains same characters
        TreeSet<Character> set2 = new TreeSet<Character>(list2);
        
        int count1[] = new int[256]; // count how many times each character is present
        
        for (int i = 0; i < word1.length(); i++) 
            count1[word1.charAt(i)]++; 
        
        
        int count2[] = new int[256]; 
        
        for (int i = 0; i < word2.length(); i++) 
            count2[word2.charAt(i)]++; 
        
        Arrays.sort(count1);
        Arrays.sort(count2);
        
        
        if(word1.length() == word2.length())
        {
            if(set1.equals(set2))
            {
                if(Arrays.equals(count1, count2))  // char count should be same
                    return true;
            }
        }
        return false;
        
    }
}
