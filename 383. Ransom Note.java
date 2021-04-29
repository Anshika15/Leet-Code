class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int arr[] = new int[26];
        for(char ch : ransomNote.toCharArray())
        {
            arr[ch - 'a']++;
        }
        
        for(int i = 0; i < 26; i++)
        {
          //  System.out.print(arr[i] + " ");
        }
        
        int arr2[] = new int[26];
        for(char ch : magazine.toCharArray())
        {
            arr2[ch - 'a']++;
        }
        
        for(int i = 0; i < 26; i++)
        {
            if(arr2[i] - arr[i] < 0)
                return false;
        }
        return true;
        

        
    }
}
