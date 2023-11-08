class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if ( fx==sx && fy==sy && t==1) return false;
        return t>=Math.max(Math.abs(fy-sy),Math.abs(fx-sx));   
     }
}