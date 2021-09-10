class Solution {
    
    String[] codes = {"0", "0", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        
        if(digits.length() == 0)
        {
            List<String> res = new LinkedList<>();
            return res;
        }
        
        List<String> res = letterC(digits);
        return res;
    }
    
    public List<String> letterC(String digits) {
        
        if(digits.length() == 0)
        {
            List<String> res = new LinkedList<>();
            res.add("");
            return res;
        }
        
        char val = digits.charAt(0);
        String ros = digits.substring(1);
        List<String> rosRes = letterC(ros);
        List<String> myRes = new LinkedList<>();
        
        for(char ch : codes[val - '0'].toCharArray())
        {
            for(String st: rosRes)
            {
                myRes.add(ch + st);
            }
        }
        
        return myRes;
        
    }
}
