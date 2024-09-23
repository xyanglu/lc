class Solution {
    public int minExtraChar(String s, String[] dictionary) {        
        Set<String> set = new HashSet();
        for (String d : dictionary)
            set.add(d);
        
        int[] dp = new int[s.length()+1];
        
        for (int i=1;i<=s.length();i++) {
            dp[i] = dp[i - 1] + 1;
         // Check for all possible end positions of words
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (set.contains(substring)) {
                    dp[i] = Math.min(dp[i], dp[j]); // No extra chars if substring is in dictionary
                }
            }
        }
        return dp[s.length()];
    }
}