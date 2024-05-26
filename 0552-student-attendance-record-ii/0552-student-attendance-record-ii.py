class Solution:
    def checkRecord(self, n: int) -> int:
        
        @functools.lru_cache(128)
        def dfs(i,A,L):
            
            if A >= 2:
                return 0
            
            if L >= 3:
                return 0
            
            if i >= n:
                return 1
            
            res = dfs(i+1,A,0);
            if A == 0:
                res += dfs(i+1,1,0)
            if L < 2:
                res += dfs(i+1,A,L+1)
            
            return res % ( 10 ** 9 + 7 )
        
        return dfs(0,0,0)