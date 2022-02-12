class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        LinkedList<String> q = new LinkedList<>();
        q.add(beginWord);
        
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord))
            return 0;
        int level = 0;
        
        while(q.size() > 0)
        {
            level++;
            if(q.contains(endWord))
            {
                return level;
            }
            int size = q.size();
            while(size-- > 0)
            {
                String curr = q.removeFirst();
                StringBuilder sb = new StringBuilder(curr);
                for(int i = 0; i < curr.length(); i++)
                {
                    for(char ch = 'a'; ch <= 'z'; ch++)
                    {
                        sb.setCharAt(i, ch);
                        if(set.contains(sb.toString()))
                        {
                            q.add(sb.toString());
                            set.remove(sb.toString());
                        }
                    }
                    sb.setCharAt(i, curr.charAt(i));
                }
            }
        }
        
        return 0;
        
    }
}
