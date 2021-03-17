class Solution {
    public boolean isPalindrome(int x) {
        
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder(str);
        sb = sb.reverse();
        String str2 = sb.toString();
        System.out.println(str2);
        if(str.equals(str2))
            return true;
        return false;
    }
}
