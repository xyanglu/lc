class Solution {
    public int[] sortArray(int[] nums) {
        int[] arr = new int[100001];
        for (int n : nums)
            arr[n+50000]++;
        
        int[] rc = new int[nums.length];
        int j = 0;
        int i = 0;
        while ( j < nums.length ) {
            while ( arr[i] == 0 )
                i++;
            for (int k=0;k<arr[i];k++)
                rc[j++] = i-50000;
            arr[i] = 0;
        }
        return rc;
    }
}