class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int countA[] = new int[7];
        int countB[] = new int[7];
        int same[] = new int[7];
        
        for(int i = 0; i < tops.length; i++)
        {
            countA[tops[i]]++;
            countB[bottoms[i]]++;
            if(bottoms[i] == tops[i])
                same[bottoms[i]]++;
        }
        
        for(int i = 1; i < 7; i++)
        {
            if(countA[i] + countB[i] - same[i] == tops.length)
                return tops.length - Math.max(countA[i] , countB[i]);
        }
        return -1;
    }
}
