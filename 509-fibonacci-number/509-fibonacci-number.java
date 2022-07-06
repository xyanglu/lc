class Solution {
    public int fib(int n) {
        if ( n == 0 ) return 0;
        if ( n < 3 ) return 1;
        
        int one = 1;
        int two = 1;
        
        for (int i=2;i<n;i++)
        {
            int temp = two;
            two = two + one;
            one = temp;
        }
        
        return two;
        
    }
}