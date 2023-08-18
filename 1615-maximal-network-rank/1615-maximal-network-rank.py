class Solution:
    def maximalNetworkRank(self, n: int, roads: List[List[int]]) -> int:
        map = {}
        for i in range(n):
            map[i] = []
        for r in roads:
            map[r[0]].append(r[1])
            map[r[1]].append(r[0])
        
        
        
        c = 0
        
        for i in range(n):
            for j in range(i+1,n):
                a = len(map[i])
                b = len(map[j])
                cur = a + b
                if i in map[j]:
                    cur-=1
                c = max(c,cur)
        
        return c