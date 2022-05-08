/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> st;
    public NestedIterator(List<NestedInteger> nestedList) {
        
        st = new Stack<>();
        flattenList(nestedList);
        
    }

    @Override
    public Integer next() {
        
        if(!hasNext())
            return null;
        return st.pop().getInteger();
        
    }

    @Override
    public boolean hasNext() {
        
        while(!st.isEmpty() && !st.peek().isInteger())
        {
            List<NestedInteger> nestedList = st.pop().getList();
            flattenList(nestedList);
        }
        
        return !st.isEmpty();
    }
    
    void flattenList(List<NestedInteger> nestedList)
    {
        for(int idx = nestedList.size() - 1; idx >= 0 ; idx--)
        {
            st.add(nestedList.get(idx));
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
