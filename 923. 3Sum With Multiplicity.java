class Solution {
    public int threeSumMulti(int[] arr, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int result = 0;
        
        for(int i = 0; i < arr.length; i++)
        {
            result = (result + map.getOrDefault(target - arr[i], 0)) % 1000000007;
            
            for (int j = 0; j < i; j++) {
                int temp = arr[i] + arr[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        
        
        return result;
        
    }
}
