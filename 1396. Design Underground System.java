class UndergroundSystem {

    HashMap<Integer, checkinPair> checkinMap; // id, {station name, time}
    HashMap<String, checkoutPair> checkoutMap; // route, {time, count}
    
    public UndergroundSystem() {
        checkinMap = new HashMap<>();
        checkoutMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkinMap.put(id, new checkinPair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        checkinPair pair = checkinMap.get(id);
        
        String station = pair.stName;
        String key = station + "-" + stationName;
        
        int totalTime = t - pair.time;
        
        if(!checkoutMap.containsKey(key))
            checkoutMap.put(key, new checkoutPair(totalTime, 1));
        else
        {
            checkoutPair p = checkoutMap.get(key);
            int count = p.count;
            int time = p.time;
            checkoutMap.put(key, new checkoutPair(time + totalTime, count+1));
        }
        
    }
    
    public double getAverageTime(String startStation, String endStation) {
        
        String key = startStation + "-" + endStation;
        checkoutPair pair = checkoutMap.get(key);
        
        double avg = (double)pair.time/(double)pair.count;
        
        return avg;
        
    }
    
    
    class checkinPair{
        String stName;
        int time;
        
        checkinPair(){}
        
        checkinPair(String stName, int time)
        {
            this.stName = stName;
            this.time = time;
        }
    }
    
    class checkoutPair{
        
        int time;
        int count;
        
        checkoutPair(){}
        
        checkoutPair(int time, int count)
        {
            this.time = time;
            this.count = count;
        }
        
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
