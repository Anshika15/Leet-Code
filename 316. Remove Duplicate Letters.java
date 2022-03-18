class Solution {
    public String removeDuplicateLetters(String s) {
        
        Stack<Character> st = new Stack<>();
        boolean vis[] = new boolean[26];
        char chars[] = new char[26];
        
        for(char ch : s.toCharArray())
        {
            chars[ch - 'a']++;
        }
        
        for(char ch : s.toCharArray())
        {
            int idx = ch - 'a';
            chars[idx]--;
            if(vis[idx])
                continue;
            while(st.size() > 0 && ch < st.peek() && chars[st.peek() - 'a'] > 0){
                char c = st.pop();
                vis[c - 'a'] = false;
            }
            st.push(ch);
            vis[ch - 'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(st.size() > 0)
            sb.append(st.pop());
        
        return sb.reverse().toString();
    }
}
