class Solution {
    public boolean isAnagram(String s, String t) {
        
        char[] s1 = s.toCharArray();
        Arrays.sort(s1);
        char s2[] = t.toCharArray();
        Arrays.sort(s2);
        
        for(int i = 0; i < s1.length; i++)
            System.out.print(s1[i] + " ");
        
        for(int i = 0; i < s2.length; i++)
            System.out.print(s2[i] + " ");
        
     //   System.out.println((Arrays.sort(s1)).equals((Arrays.sort(s2))));
        
        if(Arrays.equals(s1,s2))
            return true;
        return false;
        
    }
}
