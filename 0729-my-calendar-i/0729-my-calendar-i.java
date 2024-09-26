class MyCalendar {

    List<List<Integer>> list = new ArrayList();
    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        List<Integer> temp = new ArrayList();
        temp.add(start);
        temp.add(end);
        
        for (List<Integer> l : list)
            if (!( end<=l.get(0) || l.get(1)<=start ))
                return false;
        
        list.add(temp);
        return true;
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */