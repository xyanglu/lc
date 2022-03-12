class MovingAverage {

    int size = 0;
    int cur = 0;
    int total = 0;
    List<Integer> l = new ArrayList();
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        if ( cur < size ) 
        {
            total += val;
            cur++;
            l.add(val);
            return 1.0 * total/cur;
        }
        else {
            total -= l.remove(0);
            total += val;
            l.add(val);
            return 1.0 * total/cur;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */