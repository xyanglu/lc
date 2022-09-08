class HitCounter {

    List<Integer> list = new ArrayList();
    public HitCounter() {
        
    }
    
    public void hit(int timestamp) {
        list.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        while ( list.size() != 0 && list.get(0) <= timestamp - 300 )
            list.remove(0);
        return list.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */