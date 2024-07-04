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
    public ListNode mergeNodes(ListNode head) {
        ListNode rc = new ListNode();
        head = head.next;
        ListNode copy = rc;
        int cur = 0;
        while ( head!=null ) {
            if ( head.val == 0 ) {
                rc.next = new ListNode(cur);
                rc = rc.next;
                cur = 0;
            }
            cur += head.val;
            head = head.next;
        }
        
        
        return copy.next;
        
    }
}