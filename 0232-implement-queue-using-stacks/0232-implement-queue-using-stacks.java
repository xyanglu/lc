class MyQueue {
    
    Stack<Integer> stack = new Stack();
    Stack<Integer> other = new Stack();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        stack.add(x);
    }
    
    public int pop() {
        while ( stack.size()!=1 )
            other.add(stack.pop());
        int val = stack.pop();
        while ( !other.isEmpty() )
            stack.add(other.pop());
        return val;
    }
    
    public int peek() {
                while ( stack.size()!=1 )
            other.add(stack.pop());
        int val = stack.peek();
        while ( !other.isEmpty() )
            stack.add(other.pop());
        return val;
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */