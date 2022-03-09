class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        
        solve(s, "", wordDict, res);
        
        return res;
    }
    
    void solve(String str, String ans, List<String> dict, List<String> res)
    {
        if(str.length() == 0)
		{
		    res.add(ans.trim());
		}
		
		for(int i = 0; i < str.length(); i++)
		{
		    String left = str.substring(0, i+1);
		    if(dict.contains(left))
		    {
		        String right = str.substring(i+1);
		        solve(right, ans + left + " ", dict, res);
		    }
		}
    }
}
