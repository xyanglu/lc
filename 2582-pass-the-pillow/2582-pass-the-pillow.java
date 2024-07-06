class Solution {
    public int passThePillow(int n, int time) {
        short i = 1;
        short s = 1;
        while ( time > 0 ) {
            int distance = Math.min(time,n-1);
            i += distance * s;
            time -= distance;
            s *= -1;
        }
        
        return i;
    }
}