from typing import List

class Solution:
    def distanceLimitedPathsExist(self, n: int, edgeList: List[List[int]], queries: List[List[int]]) -> List[bool]:
        # Initialize parent and rank arrays for union-find
        parent = list(range(n))
        rank = [0] * n
        
        # Find operation for union-find
        def find(x):
            if x != parent[x]:
                parent[x] = find(parent[x])
            return parent[x]
        
        # Union operation for union-find
        def union(x, y):
            rootX, rootY = find(x), find(y)
            if rootX != rootY:
                if rank[rootX] > rank[rootY]:
                    parent[rootY] = rootX
                else:
                    parent[rootX] = rootY
                    if rank[rootX] == rank[rootY]:
                        rank[rootY] += 1
        
        # Sort edges by weight
        edgeList.sort(key=lambda x: x[2])
        
        # Initialize pointer for edges
        pointer = 0
        
        # Process queries in ascending order of limit
        sorted_queries = sorted(enumerate(queries), key=lambda x: x[1][2])
        answer = [False] * len(sorted_queries)
        for i, (p, q, limit) in sorted_queries:
            # Process edges up to limit
            while pointer < len(edgeList) and edgeList[pointer][2] < limit:
                u, v, _ = edgeList[pointer]
                union(u, v)
                pointer += 1
            # Check if p and q are connected
            if find(p) == find(q):
                answer[i] = True
        return answer
