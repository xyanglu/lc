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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = null;
        int j = 0;
        int first = -1;
        int min = Integer.MAX_VALUE;
        int max = -1;
        int p = -1;
        
        while ( head.next != null ) {
            if (prev!=null) {
                boolean match = false;
                if ( head.val < prev.val && head.val < head.next.val ) {
                    match = true;
                }
                else if ( head.val > prev.val && head.val > head.next.val ) {
                    match = true;
                }
                if ( match ) {
                    if ( p != -1 )
                        min = Math.min(min,j-p);
                    p = j;
                    if ( first != -1 ) 
                        max = Math.max(max,j - first);
                    else if ( first == -1 )
                        first = j;
                }

                    
            }
            prev = head;
            head = head.next;
            j++;
        }
        return new int[]{min==Integer.MAX_VALUE?-1:min,max};
    }
}