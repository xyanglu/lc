class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        n = len(s)
        dp = [False for i in range(n+1)]
        dp[0] = True
        
        for i in range(n):
            if not dp[i]:
                continue
            for word in wordDict:
                j = len(word)
                if i+j<=n and s[i:i+j] in wordDict:
                    dp[i+j] = True
        
        # print(dp)
        return dp[n]