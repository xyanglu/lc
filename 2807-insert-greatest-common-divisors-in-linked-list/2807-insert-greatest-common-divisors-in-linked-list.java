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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if ( head.next == null ) return head;
        ListNode next = head.next;
        int val1 = head.val;
        int val2 = next.val;
        
        int max = 1;
        for (int i=1;i<=Math.min(val1,val2);i++)
            if ( val1 % i == 0 && val2 % i == 0 )
                max = i;
        
        ListNode temp = new ListNode(max);
        //set head next
        head.next = temp;
        temp.next = next;
        
        insertGreatestCommonDivisors(next);
        return head;
    }
}