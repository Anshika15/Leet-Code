class Solution {
    public int compress(char[] chars) {
        if(chars.length == 1)
            return chars.length;
        StringBuilder sb = new StringBuilder();
        
        int j = 0;
        int i = 0;
        while(i < chars.length)
        {
            boolean flag = false;
            char prev = chars[i];
            while(i < chars.length && chars[i] == prev)
            {
                i++;
                flag = true;
            }
            if(flag)
            {
                sb.append(prev);
                if(i - j > 1){
                    sb.append((i-j));
                }
                if(i < chars.length){
                    prev = chars[i];
                    j = i;
                }
            }
        }
        System.out.println(sb.toString());
        for(int idx = 0; idx < sb.length(); idx++)
        {
            chars[idx] = sb.charAt(idx);
        }
        return sb.length();
        
    }
}
