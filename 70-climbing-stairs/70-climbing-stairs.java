class Solution {
    public int climbStairs(int n) {
        if ( n < 4 ) return n;
        int one = 1;
        int two = 2;
        
        while (n > 2) {
            int temp = two;
            two += one;
            one = temp;
            n--;
        }
        return two;
    }
}