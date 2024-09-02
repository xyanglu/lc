class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        while ( true ) {
            for (int i=0;i<chalk.length;i++) {
                if ( chalk[i] > k ) return i;
                k-=chalk[i];
            }
            
        }
    }
}