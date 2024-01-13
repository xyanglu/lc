class Solution {
    public int minSteps(String s, String t) {
        int[] arr1 = new int[26];
        for (char c : s.toCharArray() )
            arr1[c-'a']++;
        
        int[] arr2 = new int[26];
        for (char c : t.toCharArray() )
            arr2[c-'a']++;
        
        
        
        int rc =0 ;
        for (int i=0;i<26;i++)
        {
            if ( arr2[i] < arr1[i] )
            rc += arr1[i] - arr2[i] ;
        }
        return rc;
    }
}