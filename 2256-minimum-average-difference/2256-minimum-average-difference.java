class Solution {
    public int minimumAverageDifference(int[] nums) {
        long max = Integer.MAX_VALUE;
        int j = 0;
        
        long top = 0;
        long bot = 0;
        int div = 1;
        for (int n : nums)
            bot += n;
        
        for (int i=0;i<nums.length;i++) {
            int n = nums[i];
            top += n;
            bot -= n;
            
            long t1 = top/div;
            long t2 = 0;
            if ( nums.length - div != 0 )
                t2 = bot/(nums.length-div);
            //if ( i == 449988 || i == 29403)
            //System.out.println(top+"/"+div+" "+bot+"/"+(nums.length-div)+" "+Math.abs(t1-t2)+" "+i);
            long temp = Math.abs(t1-t2);
            if ( temp < max ) {
                max = temp;
                j = i;
            }
            div++;
        }
        
        
        return j;
    }
}