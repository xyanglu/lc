/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node,Node> map = new HashMap();
    public Node copyRandomList(Node head) {
        if ( head == null ) return null;
                copyRandomList(head.next);

        Node node = null;
        if ( map.containsKey(head)) 
            node = map.get(head);
        else
        {
            node = new Node(head.val);
            map.put(head,node);
        }
          
        Node next = null;
        if ( head.next!=null) {
            if (map.containsKey(head.next) )
                next = map.get(head.next);
            else {
                next = new Node(head.next.val);
                map.put(head.next,next);
            }
        }
        node.next = next;
        
        Node random = null;
        if ( head.random!=null) {
            if (map.containsKey(head.random) )
                random = map.get(head.random);
            else {
                random = new Node(head.random.val);
                map.put(head.random,random);
            }
        }
        node.random = random;        
        return node;
    }
}