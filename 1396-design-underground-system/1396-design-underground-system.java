class UndergroundSystem {

    Map<String,Integer> totalTime = new HashMap();
    Map<String,Integer> numTime = new HashMap();
    Map<Integer,Integer> inTime = new HashMap();
    Map<Integer,String> inStation = new HashMap();
    
    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        inTime.put(id, t);
        inStation.put(id,stationName);
    }
    
    public void checkOut(int id, String stationName, int t) {
        String inSta = inStation.get(id);
        String trip =  inSta+" "+stationName;
        
        totalTime.put( trip, totalTime.getOrDefault(trip,0) + t - inTime.get(id) );
        numTime.put(trip, numTime.getOrDefault(trip,0)+1);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String trip = startStation + " "+endStation;
        return (double) totalTime.get(trip) / numTime.get(trip);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */