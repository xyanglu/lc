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
        List<Integer> list = new ArrayList();
        ListNode prev = null;
        int j = 0;
        
        while ( head.next != null ) {
            if (prev!=null) {
                if ( head.val < prev.val && head.val < head.next.val )
                    list.add(j);
                else if ( head.val > prev.val && head.val > head.next.val ) 
                    list.add(j);
            }
            prev = head;
            head = head.next;
            j++;
        }
        
        
        
        if ( list.size() < 2 ) 
            return new int[]{-1,-1};
        else {
            int min = Integer.MAX_VALUE;
            for (int i=0;i+1<list.size();i++)
                min = Math.min( list.get(i+1)-list.get(i), min);
            return new int[]{min, list.get(list.size()-1)-list.get(0)};
            
            
        }
        
    }
}