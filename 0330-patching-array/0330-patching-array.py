class Solution:
    def minPatches(self, nums: List[int], n: int) -> int:
        rc = 0
        i = 0
        cur = 1
        
        while ( cur <= n ): 
            if ( i < len(nums) and nums[i] <= cur ):
                cur += nums[i]
                i+=1
            else:
                cur += cur
                rc+=1
        return rc
                