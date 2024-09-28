class MyCircularDeque {
    int size = 0;
    int cur = 0;

    class Node {
        Node left = null;
        Node right = null;
        int val = 0;
    }
    
    Node left = null;
    Node right = null;

    public MyCircularDeque(int k) {
        size = k;
        
        left = new Node();
        right = new Node();
        
        left.right = right;
        left.right.left = left;
        right.left = left;
        right.left.right = right;
    }
    
    public boolean insertFront(int value) {
        if ( cur == size ) return false;
        Node node = new Node();
        node.val = value;
        node.right = left.right;
        node.left = left;
        left.right.left = node;
        left.right = node;
        cur++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if ( cur == size ) return false;
        Node node = new Node();
        node.val = value; 
        node.left = right.left;
        node.right = right;
        right.left.right = node;
        right.left = node;
        cur++;
        return true;
    }
    
    public boolean deleteFront() {
        if ( cur == 0 ) return false;
        left.right.right.left = left.right.left;
        left.right = left.right.right;
        cur--;
        return true;
    }
    
    public boolean deleteLast() {
        if ( cur == 0 ) return false;
        right.left.left.right = right.left.right;
        right.left = right.left.left;
        cur--;
        return true;
    }
    
    public int getFront() {
        if ( cur == 0 ) return -1;
        return left.right.val;
    }
    
    public int getRear() {
        if ( cur == 0 ) return -1;
        return right.left.val;
    }
    
    public boolean isEmpty() {
        return cur == 0;
    }
    
    public boolean isFull() {
        return size == cur;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */