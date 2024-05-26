class Solution:
    def checkRecord(self, n: int) -> int:
        MOD = 10**9 + 7
        cache = {}
        def count(n):
            if n in cache:
                return cache[n]
            if n == 1:
                return {
                    (0,0): 1, (0,1): 1, (0,2): 0,
                    (1,0): 1, (1,1): 0, (1,2): 0
                }
            tmp = count(n-1)
            res = defaultdict(int)

            # Choose P
            res[(0,0)] = ( (tmp[(0,0)] + tmp[(0,1)] + tmp[(0,2)]) ) % MOD
            res[(1,0)] = ( (tmp[(1,0)] + tmp[(1,1)] + tmp[(1,2)]) ) % MOD

            # Choose L
            res[(0,1)] = tmp[(0,0)]
            res[(1,1)] = tmp[(1,0)]
            res[(0,2)] = tmp[(0,1)]
            res[(1,2)] = tmp[(1,1)]

            #Choose A
            res[(1,0)] += (tmp[(0,0)] + tmp[(0,1)] + tmp[(0,2)]) % MOD
            cache[n] = res
            return res
        return sum(count(n).values()) % MOD