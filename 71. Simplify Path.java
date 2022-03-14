class Solution {
    public String simplifyPath(String path) {
        String dirs[] = path.split("/");
        Stack<String> st = new Stack<>();
        
        for(String dir : dirs)
        {
            if(dir.equals("..") && st.size() > 0)
                st.pop();
            if(!dir.equals(".") && !dir.equals("..") && !dir.equals(""))
                st.push(dir);
        }
        
        StringBuilder sb = new StringBuilder();
        if(st.size() == 0)
            return "/";
        for(String s: st)
        {
            sb.append("/" + s);
        }
        
        return sb.toString();
    }
}
