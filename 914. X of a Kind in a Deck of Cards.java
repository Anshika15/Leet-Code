class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        
        /* first create a frequeny map now ans would be equal to gcd of the frequencies 
            if gcd(freq) <= 1 then not possible */
        
        HashMap<Integer, Integer> fmap = new HashMap<>(); // frequency map
        
        for(int i = 0; i < deck.length; i++)
        {
            fmap.put(deck[i], fmap.getOrDefault(deck[i], 0)+1);
        }
        
        int gcd = 0; // gcd of 0 with any num is that num only
        
        for(int key : fmap.keySet())
        {
            gcd = GCD(gcd, fmap.get(key));
        }
        
        if(gcd >= 2)
            return true;
        return false;
        
    }
    
    public int GCD(int a, int b)
    {
        if(b == 0)
            return a;
        return GCD(b, a%b);
    }
}
