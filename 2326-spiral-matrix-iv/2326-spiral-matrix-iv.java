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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int t = 0;
        int l = 0;
        int r = n-1;
        int b = m-1;
        
        int[][] rc = new int[m][n];
        for (int i=0;i<m;i++)
            Arrays.fill(rc[i],-1);
        
        while ( head!=null && l <= r && t <= b) {
        
            //right
            for (int i=l;head!=null&&i<=r;i++) {
                // System.out.println(t+" "+i);
                rc[t][i] = head.val;
                head = head.next;
            }
            t++;

            //down
            for (int i=t;head!=null&&i<=b;i++) {
                rc[i][r] = head.val;
                head = head.next;
            }
            r--;

            //left
            for (int i=r;head!=null&&i>=l;i--) {
                rc[b][i] = head.val;
                head = head.next;
            }
            b--;       

            //up
            for (int i=b;head!=null&&i>=t;i--) {
                rc[i][l] = head.val;
                head = head.next;
            }
            l++;
        }
        return rc;
        
    }
}