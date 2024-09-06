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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode node = new ListNode();
        ListNode v = node;
        
        Set<Integer> set = new HashSet();
        for (int n : nums)
            set.add(n);
        
        while ( head != null ) {
            if ( set.contains(head.val) ) {
                head = head.next;
                continue;
            }
            node.next = head;
            node = node.next;
            head = head.next;
        }
        node.next = null;
        
        
        return v.next;
    }
}