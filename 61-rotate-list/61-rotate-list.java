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
    public ListNode rotateRight(ListNode head, int k) {
        if ( head == null || k == 0 || head.next == null) return head;
        ListNode temp = head;
        int len = 0;
        while ( temp!=null ) {
            len++;
            temp = temp.next;
        }
        if ( k%len == 0 ) return head;
        ListNode oldHead = head;
        ListNode prev = null;
        while ( head.next!=null ) {
            prev = head;   
            head = head.next;
        }
        prev.next = null;
        head.next = oldHead;
        return rotateRight(head,k%len-1);
    }
}