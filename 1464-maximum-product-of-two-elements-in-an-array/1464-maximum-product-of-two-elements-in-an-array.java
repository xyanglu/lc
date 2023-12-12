class Solution {
    public int maxProduct(int[] nums) {
        Queue<Integer> queue = new PriorityQueue<>( (a,b) -> b - a );
        for (int i=0;i<nums.length;i++) {
            queue.add(nums[i]-1);
        }
        return queue.poll()*queue.poll();
    }
}