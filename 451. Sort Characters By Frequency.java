class Solution {
    public String frequencySort(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(char c : map.keySet())
        {
            pq.add(new Pair(c, map.get(c)));
        }
        
        StringBuilder sb = new StringBuilder();
        while(pq.size() > 0)
        {
            Pair rem = pq.remove();
            for(int j = 0; j < rem.freq; j++)
                sb.append(rem.ch);
        }
        return sb.toString();
    }
    
    class Pair implements Comparable<Pair>{
        int freq;
        char ch;
        
        Pair(char ch, int freq)
        {
            this.ch = ch;
            this.freq = freq;
        }
        
        public int compareTo(Pair p)
        {
            return p.freq - this.freq;
        }
    }
}
