class Solution {
    public String removeDuplicates(String s) {

        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray())
        {
            if(st.size() > 0 && st.peek() == ch)
                st.pop();
            else st.add(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        for(char ch : st)
        {
            sb.append(ch);
        }

        return sb.toString();
    }
}
