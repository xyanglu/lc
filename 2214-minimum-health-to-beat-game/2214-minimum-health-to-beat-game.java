class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long min = 1;
        
        Arrays.sort(damage);
        
        for (int i=damage.length-1;i>=0;i--) {
            int d = damage[i];
            
            if ( armor != 0 && d > armor ) {
                min += d - armor;
                armor = 0;
            }
            else if ( armor != 0 ) {
                min += Math.max(0, d - armor);
                armor = 0;
            }
            else
                min += d;
            
            
        }
        
        
        
        return min;
    }
}