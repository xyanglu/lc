class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int[] arr1 = new int[101];
        for (int s : seats)
            arr1[s]++;
        
        int[] arr2 = new int[101];
        for (int s : students)
            arr2[s]++;
        
        int i = 0, j = 0;
        int rc = 0;
        while ( i < 101 ) {
            while ( i < 101 && arr1[i] == 0 )
                i++;
            while ( j < 101 && arr2[j] == 0 )
                j++;
            if ( i == 101 || j == 101 ) return rc;
            arr2[j]--;
            arr1[i]--;
            rc += Math.abs(j - i);
        }
        return rc;
    }
}