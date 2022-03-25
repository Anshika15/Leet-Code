class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Pair[] arr = new Pair[costs.length];
        
        for(int i = 0; i < costs.length; i++)
            arr[i] = new Pair(costs[i][0], costs[i][1]);
        Arrays.sort(arr);
        
        int result = 0;
        for(int i = 0; i < costs.length; i++)
        {
            if(i < costs.length/2)
                result += arr[i].b;
            else
                result += arr[i].a;
        }
        return result;
    }
    
    class Pair implements Comparable<Pair>{
        int a;
        int b;
        int diff;
        Pair(int a, int b)
        {
            this.a = a;
            this.b = b;
            this.diff = b - a;
        }
        
        public int compareTo(Pair p)
        {
            return this.diff - p.diff;
        }
    }
    
}
