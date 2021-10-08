class Trie {

    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        
        root = new Node();
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {

        Node curr = root;
        for(char ch : word.toCharArray())
        {
            if(curr.arr[ch-'a'] == null)
            {
                curr.arr[ch-'a'] = new Node();
            }
            curr = curr.arr[ch-'a'];
        }
        
        curr.isEnd =  true;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node curr = root;
        for(char ch : word.toCharArray())
        {
            if(curr.arr[ch-'a'] == null)
            {
                return false;
            }
            curr = curr.arr[ch-'a'];
        }
        
        return curr.isEnd; 
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        Node curr = root;
        
        for(char ch : prefix.toCharArray())
        {
            if(curr.arr[ch-'a'] == null)
            {
                return false;
            }
            curr = curr.arr[ch-'a'];
        }
        
        return true; 
        
    }
}

class Node{
    Node arr[];
    boolean isEnd;
    Node()
    {
        arr = new Node[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
