class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {

        int n = arr.length;
        int r = n - 1;
        
            //prefix
        while ( r > 0 && arr[r-1] <= arr[r] )
            r--;
        
        int res = r;
        
        //suffix
        
        int l = 0;
        while ( l + 1 < n && arr[l] <= arr[l+1] )
            l++;
        
        res = Math.min(res,n-1-l);
        
        //midarray
        
        l = 0;
        r = n-1;
        
        while (l<r) {
            while ( r < n && l +1 < r && arr[r-1] <= arr[r] && arr[l] <= arr[r] )
                r--;
            
            while ( r < n && arr[l] > arr[r] )
                r++;
            
            res = Math.min(res,r-l-1);
            if ( arr[l] > arr[l+1] ) break;
            l++;
        }
        
        
        return res;
        
    }
}