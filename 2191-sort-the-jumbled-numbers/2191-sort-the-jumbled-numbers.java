class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] rc = new int[nums.length];
        Map<Integer,Integer> map = new HashMap();
        for (int i=0;i<10;i++)
            map.put(i,mapping[i]);
        
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i=0;i<n;i++) {
            arr[i][0] = i;
            int v  = nums[i];
            int base = 1;
            int val = 0;
            while ( String.valueOf(base).length() <= String.valueOf(nums[i]).length() ) {
                int b = v % 10;
                v /= 10;
                val += map.get(b)*base;
                base*=10;
            }
             // System.out.println(nums[i]+" "+val);
            arr[i][1] = val;
        }
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        
        for (int i=0;i<n;i++)
            rc[i] = nums[ arr[i][0] ];
        
        
        return rc;
    }
}