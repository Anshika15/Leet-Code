class Solution {
    public String sortSentence(String s) {
        
        HashMap<Integer, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        String[] strs = s.split(" ");
        for(String str : strs)
        {
            char ch = str.charAt(str.length()-1);
            map.put(ch-'0', str.substring(0, str.length()-1));
        }
        
        for(int i = 1; i <= strs.length; i++)
            sb.append(map.get(i) + " ");
        return sb.toString().trim();
        
    }
}
