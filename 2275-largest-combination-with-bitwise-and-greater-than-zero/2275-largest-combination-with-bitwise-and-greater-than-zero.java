class Solution {
    public int largestCombination(int[] candidates) {
        int max = 0;
        int[] arr = new int[32];
        
        for (int n : candidates)
        {
            int i = 0;
            while (n > 0) {
                arr[i] += 1 & n;
                n = n>>1;
                i++;
            }
        }
        
        for (int i=0;i<32;i++)
            max = Math.max(max,arr[i]);
        return max;
    }
}