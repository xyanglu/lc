class FreqStack {

    Map<Integer,Integer> map = new HashMap();
    Map<Integer,Stack<Integer>> stack = new HashMap();
    int max = 0;
    public FreqStack() {
        
    }
    
    public void push(int val) {
        map.put(val,map.getOrDefault(val,0)+1);
        int f = map.get(val);
        max = Math.max(f,max);
        if ( !stack.containsKey(f) )
            stack.put(f,new Stack());
        stack.get(f).add(val);
    }
    
    public int pop() {
        int val = stack.get(max).pop();
        if ( stack.get(max).size() == 0 )
            max--;
        map.put(val,map.get(val)-1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */