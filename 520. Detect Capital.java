class Solution {
    public boolean detectCapitalUse(String word) {
        
        char firstch = word.charAt(0);
        String restStr = word.substring(1);
        
        boolean cap = false;
        int count = 0;
        for(int i = 0; i < restStr.length(); i++)
        {
            if(Character.isUpperCase(restStr.charAt(i)))
            {
                cap = true;
                count++;
            }
        }
        
        if(Character.isUpperCase(firstch) && (count == 0 || count == restStr.length()))
           return true;
        if(Character.isLowerCase(firstch) && count == 0)
           return true;
         return false;
    }
}
