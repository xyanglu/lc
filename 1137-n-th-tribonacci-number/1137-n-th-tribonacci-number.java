class Solution {
    public int tribonacci(int n) {
        if ( n < 2 ) return n;
        if ( n == 2 ) return 1;
        int fast = 1;
        int slow = 1;
        int slower = 0;
        
        for (int i=3;i<=n;i++) {
            int temp1 = fast;
            int temp2 = slow;
            fast += slow + slower;
            slow = temp1;
            slower = temp2;
            
        }
        return fast;
    }
}