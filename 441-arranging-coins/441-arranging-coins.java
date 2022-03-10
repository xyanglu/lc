class Solution {
    public int arrangeCoins(int n) {
        int comp = 0;
        int base = 1;
        while ( base <= n ) {
            n -= base;
            base++;
            comp++;
        }
        return comp;
    }
}