class CustomStack {

    int k =0;
    Stack<Integer> stack = new Stack();
    
    public CustomStack(int maxSize) {
        k = maxSize;
    }
    
    public void push(int x) {
        if ( stack.size() == k ) return;
        stack.add(x);
    }
    
    public int pop() {
        if ( stack.isEmpty() ) return -1;
        return stack.pop();
    }
    
    public void increment(int k, int val) {
        int size = stack.size();
        int rem = size - k;
        List<Integer> list = new ArrayList();
        for (int i=0;i<rem&&!stack.isEmpty();i++)
            list.add(0,stack.pop());
        for (int i=0;i<k&&!stack.isEmpty();i++)
            list.add(0,stack.pop()+val);
        for (int l : list)
            stack.add(l);
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */