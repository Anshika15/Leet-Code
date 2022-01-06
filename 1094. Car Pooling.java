class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        int lastDropLocation = -1;
    for(int trip[] : trips)
    {
        lastDropLocation = Math.max(lastDropLocation, trip[2]);
    }
    
    int passCountArr[] = new int[lastDropLocation+1];
    
    for(int i = 0; i < trips.length; i++)
    {
        passCountArr[trips[i][1]] += trips[i][0];
        passCountArr[trips[i][2]] -= trips[i][0];
    }
    
    for(int i = 1; i <= lastDropLocation; i++)
    {
        passCountArr[i] += passCountArr[i-1];
        if(passCountArr[i] > capacity)
            return false;
    }
    if(passCountArr.length >= 1 && passCountArr[0] > capacity)
        return false;
    return true;
        
    }
}
