class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        
        while(!stack.isEmpty())
        {
            int c = stack.pop();
            for(int val: rooms.get(c))
            {
                if(!set.contains(val))
                {
                    set.add(val);
                    stack.add(val);
                }
            }
        }
        
        if(set.size() == rooms.size())
            return true;
        
        return false;
    }
}
