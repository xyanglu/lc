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
    public ListNode partition(ListNode head, int x) {
        ListNode d = new ListNode();
        d.next = head;
        ListNode p = d;
        
        ListNode dummy = new ListNode();
        ListNode dup = dummy;
        
        while ( d.next!=null ) {
            ListNode temp = d.next;
            if ( d.next.val < x ) 
            {
                dummy.next = temp;
                d.next = d.next.next;
                dummy = dummy.next;
            }
            else
                d = d.next;
        }  
        dummy.next = p.next;
        
        
        return dup.next;
        
        
    }
}