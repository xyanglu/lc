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
    public ListNode swapNodes(ListNode head, int k) {
        List<ListNode> list = new ArrayList();
        while ( head!=null )
        {
            list.add(head);
            head = head.next;
        }
        int len = list.size();
        
        int temp = list.get(len-k).val;
        list.get(len-k).val = list.get(k-1).val;
        list.get(k-1).val = temp;
        
        return list.get(0);
    }
}