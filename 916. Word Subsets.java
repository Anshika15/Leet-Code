class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        
        int c[] = new int[26];
        int temp[];
        
        for(int i = 0; i < B.length; i++)
        {
            temp = count(B[i]);
            for(int j = 0; j < 26; j++)
            {
                c[j] = Math.max(c[j], temp[j]);
            }
        }
        int j = 0;
        List<String> list = new ArrayList<>();
        for(int i = 0; i < A.length; i++)
        {
            temp = count(A[i]);
            
            for(j = 0 ; j < 26; j++)
            {
                if(temp[j] < c[j])
                    break;
            }
            if(j == 26)
                list.add(A[i]);
        }
        return list;
        
    }
    
    public int[] count(String str)
    {
        int temp[] = new int[26];
        for(char c: str.toCharArray())
                temp[c - 'a']++;
        return temp;
    }
}
