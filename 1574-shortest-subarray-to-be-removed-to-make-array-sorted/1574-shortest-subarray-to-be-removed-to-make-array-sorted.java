class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {

        int n = arr.length;
        int r = n - 1;
        
            //prefix
        while ( r > 0 && arr[r-1] <= arr[r] )
            r--;
        
        int res = r;
        
        //postfix
        
        int l = 0;       
        while (l<r) {            
            while ( r < n && arr[l] > arr[r] )
                r++;     
            res = Math.min(res,r-l-1);
            if ( arr[l] > arr[l+1] ) break;
            l++;
        }
        
        
        return res;
        
    }
}