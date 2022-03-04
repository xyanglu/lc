class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int cur = 0;
        for (int i=1;i<prices.length;i++) {
            cur = Math.max(0,prices[i] - prices[i-1] + cur);
            max = Math.max(cur,max);
        }
        return max;
    }
}