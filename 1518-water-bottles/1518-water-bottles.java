class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int rc = 0;
        
        while ( numBottles >= numExchange ) {
            int val = numBottles / numExchange;
            rc+=val*numExchange;
            numBottles -= (numExchange-1) * val;
        }
        
        return rc+numBottles;
        
    }
}