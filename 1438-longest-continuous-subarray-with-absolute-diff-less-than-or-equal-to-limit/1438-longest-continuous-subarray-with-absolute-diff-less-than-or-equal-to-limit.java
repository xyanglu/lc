class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int rc = 0;
        Queue<Integer> q1  = new PriorityQueue<>( (a,b) -> a - b );
        Queue<Integer> q2  = new PriorityQueue<>( (a,b) -> b - a );
        int prev = 0;
        int j = 0;
        for (int n : nums) {
            q1.add(n);
            q2.add(n);
            
            while ( !q1.isEmpty() && !q2.isEmpty() && q2.peek() - q1.peek() > limit ) {
                prev--;
                q1.remove(nums[j]);
                q2.remove(nums[j]);
                j++;
            }
            prev++;
            rc = Math.max(rc, prev);
        }
        return rc;
    }
}