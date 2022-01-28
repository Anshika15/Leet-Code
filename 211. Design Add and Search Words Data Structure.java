class WordDictionary {
    
    class Trie{
        Trie[] childrens;
        boolean isEnd;
        
        Trie(){
            childrens = new Trie[26];
        }
        
        boolean find(String word, int idx)
        {
            if(word.length() == idx)
                return isEnd;
            if(word.charAt(idx) == '.')
            {
                for(Trie child : childrens)
                {
                    if(child != null && child.find(word, idx+1))
                        return true;
                }
                return false;
            }
            else
            {
                if(childrens[word.charAt(idx) - 'a'] == null)
                {
                    return false;
                }
                else
                {
                    return childrens[word.charAt(idx) - 'a'].find(word, idx+1);
                }
            }
        }
    }

    Trie root;
    public WordDictionary() {
        
        root = new Trie();
        
    }
    
    public void addWord(String word) {
        
        Trie curr = root;
        for(char ch: word.toCharArray())
        {
            if(curr.childrens[ch-'a'] == null)
                curr.childrens[ch-'a'] = new Trie();
            curr = curr.childrens[ch-'a'];
        }
        curr.isEnd = true;
        
    }
    
    public boolean search(String word) {
        return root.find(word, 0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
