class FreqStack {

    Map<Integer,Integer> map = new HashMap();
    Map<Integer,Stack<Integer>> stack = new HashMap();
    int max = 0;
    
    public FreqStack() {
        
    }
    
    public void push(int val) {
        int freq = map.getOrDefault(val,0) + 1;
        max = Math.max(max,freq);
        if ( !stack.containsKey(freq) )
            stack.put(freq,new Stack());
        stack.get(freq).add(val);
        map.put(val,freq);
        
    }
    
    public int pop() {
        int val = stack.get(max).pop();
        map.put(val,map.get(val)-1);
        if ( stack.get(max).size() == 0 )
            max--;
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */