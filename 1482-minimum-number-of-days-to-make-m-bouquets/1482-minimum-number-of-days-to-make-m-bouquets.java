class Solution {
    public int minDays(int[] bloomDay, int M, int k) {
        int l = Integer.MAX_VALUE, r = 1;
        
        // Find the minimum and maximum bloom days in the array
        for (int b : bloomDay) {
            l = Math.min(l, b);
            r = Math.max(r, b);
        }
        
        int ans = -1;
        
        // Perform binary search on the possible days
        while (l <= r) {
            int rc = 0;
            int i = 0;
            int m = (l + r) / 2;
            int prev = 0;
            
            // Count how many bouquets can be formed with maximum day `m`
            while (i < bloomDay.length) {
                while (i < bloomDay.length && bloomDay[i] > m) {
                    i++;
                    prev = 0;
                }
                
                if (i < bloomDay.length) {
                    prev++;
                    if (prev == k) {
                        rc++;
                        prev = 0; // Reset prev as we found a bouquet
                    }
                    i++;
                }
            }
            
            // Check if we can achieve at least `M` bouquets
            if (rc >= M) {
                ans = m;
                r = m - 1; // Try to find a smaller `m`
            } else {
                l = m + 1; // Otherwise, try a larger `m`
            }
        }
        
        return ans;
    }
}
