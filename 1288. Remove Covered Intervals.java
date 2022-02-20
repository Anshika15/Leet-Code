class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        Pair[] arr = new Pair[intervals.length];
        int count = 1;
        
        for(int i = 0; i < intervals.length; i++)
        {
            arr[i] = new Pair(intervals[i][0], intervals[i][1]);
        }
        
        Arrays.sort(arr);
        
        int start = arr[0].start;
        int end = arr[0].end;
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i].start >= start && arr[i].end <= end)
                continue;
            else
            {
                count++;
                start = arr[i].start;
                end = arr[i].end;
            }
        }
        return count;
        
    }
    
    class Pair implements Comparable<Pair>{
        int start;
        int end;
        
        Pair(){}
        
        Pair(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
        
        public int compareTo(Pair p)
        {
            if(this.start != p.start)
                return this.start - p.start;
            return p.end - this.end;
        }
    }
}
