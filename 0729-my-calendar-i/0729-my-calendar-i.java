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
            if (!( end <= node.start || start >= node.end ))
                return false;
            if ( end <= node.start && node.left != null ) {
                node = node.left;
                continue;
            }
            if ( start >= node.end && node.right != null ) {
                node = node.right;
                continue;
            }
            if ( end <= node.start && node.left == null ) {
                Node temp = new Node();
                temp.start = start;
                temp.end = end;
                node.left = temp;
                return true;
            }
            if ( start >= node.end && node.right == null ) {
                Node temp = new Node();
                temp.start = start;
                temp.end = end;
                node.right = temp;
                return true;
            }
            
        }
        
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */