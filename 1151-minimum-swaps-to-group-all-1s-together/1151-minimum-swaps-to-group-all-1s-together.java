class Solution {
    public int minSwaps(int[] data) {
        int ones = 0;
        for (int d : data)
            ones += d;
        
        int min = Integer.MAX_VALUE;
        int cur = 0;
        int i = 0;
        for (i=i;i<ones;i++)
            cur += data[i];
        min = ones - cur;
        
        i = 0;
        for (int j=ones;j<data.length;j++) 
        {
            cur += data[j];
            cur -= data[i++];
            min = Math.min(ones-cur,min);
        }
        return min;
    }
}