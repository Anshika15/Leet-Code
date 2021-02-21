class Solution {
    
    class Pair{
        int element;
        int index;
        Pair(int element, int index)
        {
            this.element = element;
            this.index = index;
        }
    }
    
    
    public int largestRectangleArea(int[] heights) {
        
       int[] nsl = NSL(heights);
       int[] nsr = NSR(heights);
       
       int width[] = new int[heights.length];
       for(int i = 0; i < heights.length; i++)
           width[i] = nsr[i] - nsl[i] - 1;
        
       int res[] = new int[heights.length];
        int max = Integer.MIN_VALUE;
       for(int i = 0; i < heights.length; i++)
       {
           res[i] = width[i] * heights[i];
           max = Math.max(max, res[i]);
       }
          
        return max;
    }
    
    public int[] NSL(int[] arr)
    {
        int res[] = new int[arr.length];
        Stack<Pair> s = new Stack<Pair>();
        int pseudo = -1;
        for(int i = 0; i < arr.length; i++)
        {
            if(s.size() == 0)
            {
                res[i] = pseudo;
            }
            else if(s.size() > 0 && arr[i] > s.peek().element)
            {
                res[i] = s.peek().index;
            }
            else if(s.size() > 0 && arr[i] <= s.peek().element)
            {
                while(s.size() > 0 && arr[i] <= s.peek().element)
                    s.pop();
                if(s.size() == 0)
                    res[i] = pseudo;
                else
                {
                    res[i] = s.peek().index;
                }
            }
            s.push(new Pair(arr[i], i));
        }
        return res;
    }
    
    
    public int[] NSR(int[] arr)
    {
        int res[] = new int[arr.length];
        Stack<Pair> s = new Stack<Pair>();
        int pseudo = arr.length;
        for(int i = arr.length - 1; i >= 0; i--)
        {
            if(s.size() == 0)
            {
                res[i] = pseudo;
            }
            else if(s.size() > 0 && arr[i] > s.peek().element)
            {
                res[i] = s.peek().index;
            }
            else if(s.size() > 0 && arr[i] <= s.peek().element)
            {
                while(s.size() > 0 && arr[i] <= s.peek().element)
                    s.pop();
                if(s.size() == 0)
                    res[i] = pseudo;
                else
                {
                    res[i] = s.peek().index;
                }
            }
            s.push(new Pair(arr[i], i));
        }
        return res;
    }
}
