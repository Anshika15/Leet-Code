class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> res = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        solution(s, res, list);
        
        return res;
    }
    
    public void solution(String s, List<List<String>> res, ArrayList<String> list)
    {
        if(s.length() == 0)
        {
            ArrayList<String> l = new ArrayList<>(list);
            // Collections.sort(l);
            res.add(l);
            return;
        }
            
        for(int i = 0; i < s.length(); i++)
        {
            String prefix = s.substring(0, i+1);
            String ros = s.substring(i+1);
            
            if(isPalindromic(prefix))
            {
                list.add(prefix);
                solution(ros, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public boolean isPalindromic(String str)
    {
        int left = 0;
        int right = str.length() - 1;
        
        while(left < right)
        {
            char l = str.charAt(left);
            char r = str.charAt(right);
            if(l != r)
                return false;
            left++;
            right--;
        }
        return true;
    }
}
