class Solution {
    public String findLongestWord(String s, List<String> d) {

        Collections.sort(d, (a,b) -> (a.length() == b.length()) ? a.compareTo(b) : a.length() - b.length());
        System.out.println(d);
         
        int max = Integer.MIN_VALUE;
        String res = new String();
        
        for(String ele: d)
        {
            int j = 0;
            for(int i = 0; i < s.length(); i++)
            {
                if(j >= ele.length())
                    break;
                
                if(s.charAt(i) == ele.charAt(j))
                    j++;
            }
            if(j > max && j == ele.length())
            {
                max = j;
                res = ele;
            }
        }
        
        return res;
    }
}
