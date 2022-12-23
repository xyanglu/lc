class Solution {
    Map<String,Integer> dp;
    public int maxProfit(int[] prices) {
        dp = new HashMap();
        return dfs(0,true,prices);
        
    }
    int dfs(int i, boolean b, int[] prices) {
        if ( i >= prices.length )
            return 0;
        if ( dp.containsKey(i+""+b))
            return dp.get(i+""+b);
        
        int cooldown = dfs(i+1,b,prices);
        if (b) {
            int buy = dfs(i+1, !b,prices) - prices[i];
            dp.put(i+""+b,Math.max(buy,cooldown));
        }
        else
        {
            int sell = dfs(i+2,!b,prices) + prices[i];
            dp.put(i+""+b,Math.max(sell,cooldown));
        }
        return dp.get(i+""+b);
    }
}