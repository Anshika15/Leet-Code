class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        while(i < j)
        {
          if(s.charAt(i) == s.charAt(j))
          {
            i++;
            j--;
          }
          else
          {
            // skip char from left or right -> delete at most 1 char
            return isPossible(s, i+1, j) || isPossible(s, i, j-1);
          }
        }
        return true;
      }

       boolean isPossible(String s, int i, int j)
      {
        while(i < j)
        {
          if(s.charAt(i) == s.charAt(j))
          {
            i++;
            j--;
          }
          else{
            return false;
          }
        }
        return true;
      }
}
