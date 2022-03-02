class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[ days[days.length-1]+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dfs(dp,0,days,costs);
        
        return dp[0];
    }
    int dfs(int[] dp, int d, int[] days, int[] costs) {
        if ( d == days.length ) return 0;
        if ( dp[d] != Integer.MAX_VALUE ) return dp[d];
        
        for (int i=0;i<costs.length;i++) {
            int day = new int[]{1,7,30}[i];
            int c = costs[i];
            int j = d;
            while ( j < days.length && days[j] < days[d] + day)
                j++;
            dp[d] = Math.min(dp[d],c + dfs(dp,j,days,costs));
        }
        return dp[d];
    }
}