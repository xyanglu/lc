class MyCalendar {

    class Node {
        Node left = null;
        Node right = null;
        int start = 0;
        int end = 0;
    }
    
    Node root = null;
    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        if ( root == null ) 
        {
            root = new Node();
            root.start = start;
            root.end = end;
            return true;
        }
        Node node = root;
        while (true) {
            if ( end <= node.start ) {
                if ( node.left == null ) {
                    Node temp = new Node();
                    temp.start = start;
                    temp.end = end;
                    node.left = temp;
                    return true;
                }
                node = node.left;
            }
            else if ( start >= node.end ) {
                if ( node.right == null ) {
                    Node temp = new Node();
                    temp.start = start;
                    temp.end = end;
                    node.right = temp;
                    return true;
                }
                node = node.right;
            }
            else
                return false;
        }
        
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */