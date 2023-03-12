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
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> list = new ArrayList();
        if ( lists.length == 0 ) return null;
        for (ListNode l : lists)
            list.add(l);
        
        while ( list.size() > 1 ) {
            ListNode l1 = list.remove(0);
            ListNode l2 = list.remove(0);
            
            list.add( dfs(l1,l2) );
            
        }
        
        
        return list.get(0);
        
        
    }
    ListNode dfs(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        
        while ( l1 != null && l2 != null ) {
            if ( l1.val < l2.val )
            {
                cur.next = l1;
                l1 = l1.next;
            }
            else
            {
                cur.next = l2;
                l2 = l2.next;
            }
            
            
            cur = cur.next;
        }
        if ( l1 != null )
            cur.next = l1;
        if ( l2 != null )
            cur.next = l2;
        
        
        
        return dummy.next;
    }
}