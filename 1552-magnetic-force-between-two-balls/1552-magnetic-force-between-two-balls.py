class Solution:
    def maxDistance(self, position: List[int], m: int) -> int:
        position.sort()
        
        def canPlaceBalls(minForce):
            count = 1  # Place the first ball in the first basket
            last_position = position[0]
            
            for i in range(1, len(position)):
                if position[i] - last_position >= minForce:
                    count += 1
                    last_position = position[i]
                    if count == m:  # Early termination if we placed all balls
                        return True
            return False
        
        left, right = 1, position[-1] - position[0]
        best_distance = 0
        
        while left <= right:
            mid = (left + right) // 2
            if canPlaceBalls(mid):
                best_distance = mid  # Found a valid solution with this minForce
                left = mid + 1  # Try for a larger minForce
            else:
                right = mid - 1  # Need a smaller minForce
        
        return best_distance
