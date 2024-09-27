class MyCalendarTwo {

    List<List<Integer>> inter = new ArrayList();
    List<List<Integer>> outer = new ArrayList();
    
    public MyCalendarTwo() {
        
    }
    
    public boolean book(int start, int end) {
        for (List<Integer> l : inter) {
            if (! (end<=l.get(0) || start>=l.get(1)))  return false;
        }
        
        for (List<Integer> l : outer) {
            if (! (end<=l.get(0) || start>=l.get(1)))  {
                int s = Math.max(start,l.get(0));
                int e = Math.min(end,l.get(1));
                List<Integer> temp = new ArrayList();
                temp.add(s);
                temp.add(e);
                inter.add(temp);
            }
        }
        
        
        List<Integer> temp = new ArrayList();
        temp.add(start);
        temp.add(end);
        outer.add(temp);
        
        
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */