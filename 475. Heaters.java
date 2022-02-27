class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        
        Arrays.sort(heaters);
        int res = 0;
        
        for(int i = 0; i < houses.length; i++)
        {
            Pair p = findFloorCeil(heaters, houses[i]);
            
            int d1 = (p.floor == -1 ? Integer.MAX_VALUE : houses[i] - p.floor);
            int d2 = (p.ceil == -1 ? Integer.MAX_VALUE : p.ceil - houses[i]);
            
            res = Math.max(res, Math.min(d1,d2));
        }
        
        return res;
        
    }
    
    class Pair{
        int floor = -1;
        int ceil = -1;
        
        Pair(){}
        
        Pair(int ceil, int floor)
        {
            this.ceil = ceil;
            this.floor = floor;
        }
    }
    
    Pair findFloorCeil(int[] arr, int num)
    {
        Pair res = new Pair();
        
        int left = 0;
        int right = arr.length-1;
        
        while(left <= right)
        {
            int mid = left + (right-left)/2;
            if(arr[mid] == num)
            {
                res.floor = arr[mid];
                res.ceil = arr[mid];
                return res;
            }
            else if(arr[mid] < num)
            {
                res.floor = arr[mid];
                left = mid+1;
            }
            else
            {
                res.ceil = arr[mid];
                right = mid-1;
            }
        }
        
        return res;
    }
}
