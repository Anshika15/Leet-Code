class RandomizedSet {

    HashMap<Integer, Integer> map;
    int idx;
    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        idx = 0;
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val, idx);
            idx++;
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        
        if(map.containsKey(val)){
            map.remove(val);
            return true;
        }
        return false;
        
    }
    
    public int getRandom() {
        
        Random rand = new Random();
        // System.out.println(rand.nextInt(map.size()));
        int index = rand.nextInt(map.size());
        
        Set<Integer> keySet = map.keySet();
  
        Integer[] keyArray
            = keySet.toArray(new Integer[keySet.size()]);
        
        return keyArray[index];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
