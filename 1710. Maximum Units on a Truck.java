class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        Pair[] comps = new Pair[boxTypes.length];
        for(int idx = 0; idx < boxTypes.length; idx++)
        {
            comps[idx] = new Pair(boxTypes[idx][0], boxTypes[idx][1]);
        }
        
        Arrays.sort(comps);
        int result = 0;
        for(Pair p : comps)
        {
            if(truckSize >= p.boxes)
            {
                result += p.boxes * p.units;
                truckSize -= p.boxes;
            }
            else
            {
               result += truckSize * p.units;
               return result;
            }
               
        }
        return result;
        
    }
    
    class Pair implements Comparable<Pair>{
        
        int boxes;
        int units;
        Pair(int boxes, int units)
        {
            this.boxes = boxes;
            this.units = units;
        }
        
        public int compareTo(Pair p)
        {
            return p.units - this.units;
        }
    }
}
