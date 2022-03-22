class Solution {
    public String getSmallestString(int n, int k) {
       HashMap<Integer, Character> map = new HashMap<>();
        char ch = 'a';
        for(int i = 1; i <= 26; i++){
            map.put(i, ch);
            ch++;
        }
        // System.out.println(map);
        StringBuilder sb = new StringBuilder();
        while(n > 0)
        {
            int val = k - n + 1;
            if(val >= 26){
                sb.append("z");
                k = k-26;
            }
            else{
                sb.append(map.get(val)+"");
                k = k-val;
            }
            n--;
        }
        return sb.reverse().toString();
        
    }
}
