/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if ( head == null ) return null;
        ListNode even = head.next;
        
        ListNode dummy = new ListNode();
        ListNode d = dummy;
        
        Queue<ListNode> queue = new LinkedList();
        while ( head != null )
        {
            queue.add(head);
            if ( head.next != null)
                head = head.next.next;
            else
                head = null;
        }
        while ( even != null ) {
            //System.out.println(even.val);
            queue.add(even);
           if ( even.next != null)
                even = even.next.next;
            else
                even = null;        
        }
        while (!queue.isEmpty())
        {
            dummy.next = queue.poll();
            dummy = dummy.next;
        }
        dummy.next = null;
        
        
        return d.next;
    }
}