class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int max = 0;
        
        int[][] arr = new int[plantTime.length][2];
        for (int i=0;i<arr.length;i++)
            arr[i] = new int[]{plantTime[i],growTime[i]};
        
        Arrays.sort(arr,(a,b) -> b[1] - a[1]);
        
        int p = 0;
                for (int i=0;i<arr.length;i++) {
                    
                    p += arr[i][0];
                    max = Math.max(max, p + arr[i][1]);
                }
        
        return max;
    }
}