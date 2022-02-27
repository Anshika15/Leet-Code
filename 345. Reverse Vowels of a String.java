class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        
        int left = 0;
        int right = arr.length-1;
        
        while(left < right)
        {
            // move left pointer to vowel
            while(left < right && !isVowel(arr, left))
                left++;
            // move right pointer to vowel
            while(left < right && !isVowel(arr, right))
                right--;
            swap(arr, left, right);
            left++;
            right--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < arr.length; i++)
            sb.append(arr[i] + "");
        
        return sb.toString();
    }
    
    boolean isVowel(char[] arr, int idx)
    {
        if(arr[idx] == 'a' || arr[idx] == 'e' || arr[idx] == 'i' || arr[idx] == 'o' || arr[idx] == 'u' || arr[idx] == 'A' || arr[idx] == 'E' || arr[idx] == 'I' || arr[idx] == 'O' || arr[idx] == 'U')
            return true;
        return false;
    }
    
    void swap(char[] arr, int idx1, int idx2)
    {
        char temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
