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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] rc = new ListNode[k];
        if ( head == null ) return rc;
        ListNode h = head;
        int len = 0;
        while ( head != null ) 
        {
            len++;
            head = head.next;
        }
        int l = len / k;
        int first = len % k;
        if ( len < k )
        {
            l = 1;
            first = 0;
        }
        // System.out.println(l);
        int i = 0;
        while ( i < rc.length ) {
            int leng = l;
            if ( i < first )
                leng++;;
            rc[i] = h;
            int j = 1;
            while ( j++ < leng && h!= null ) 
                h = h.next;
            if ( h!=null ) {
                ListNode temp = h.next;
                h.next = null;
                h = temp;
            }
            i++;
        }
        
        return rc;
    }
}