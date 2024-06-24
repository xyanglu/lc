class Solution {
    public int minKBitFlips(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList();
        int rc = 0;
        
        for (int i=0;i<nums.length;i++) {
            if ( !queue.isEmpty() && i > queue.peek() + k - 1 ) queue.poll();
            if ( (nums[i] + queue.size() ) % 2 == 0 ) {
                if ( i + k > nums.length ) return -1;
                queue.add(i);
                rc++;
            }
        }
        return rc ;
    }
}