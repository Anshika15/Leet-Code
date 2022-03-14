class Solution {
    public boolean canReorderDoubled(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        Integer[] array = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++)
        {
            array[i] = arr[i];
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        
        Arrays.sort(array, (a,b)->{
            return Math.abs(a) - Math.abs(b);
        });
        
            
        for(Integer val : array)
        {
           if(map.get(val) == 0)
                continue;
            if(map.getOrDefault(2*val, 0) == 0)
                return false;
            else
            {
                map.put(val, map.get(val)-1);
                map.put(val*2, map.get(2*val)-1);
            }
        }
        return true;
        
    }
}
