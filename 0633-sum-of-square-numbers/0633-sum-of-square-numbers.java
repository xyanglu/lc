class Solution {
    public boolean judgeSquareSum(int c) {
        double left = 0, right = (int) Math.sqrt(c);
        
        while (left<=right) {
            double total = left*left + right*right;
            if ( total > c ) 
                right --;
            else if ( total < c ) 
                left++;
            else
                return true;
        }
        return false;
    }
}