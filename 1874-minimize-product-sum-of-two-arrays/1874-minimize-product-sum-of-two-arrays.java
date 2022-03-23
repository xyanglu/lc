class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        int val = 0;
        
        Integer[] n1 = new Integer[nums1.length];
        for (int i=0;i<nums1.length;i++)
            n1[i] = Integer.parseInt ( String.valueOf(nums1[i]) );
        Arrays.sort(n1, (a,b) -> b - a );
        Arrays.sort(nums2);
        for (int i=0;i<nums1.length;i++)
            val += n1[i] * nums2[i];
        
        return val;
    }
}