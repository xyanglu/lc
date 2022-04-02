class Solution {
    public void reverseString(char[] s) {
        rev(s,0,s.length-1);
    }
    void rev(char[] s, int l, int r) {
        if ( l >= r ) return;
        char c = s[l];
        s[l] = s[r];
        s[r] = c;
        rev(s,l+1,r-1);
    }
}