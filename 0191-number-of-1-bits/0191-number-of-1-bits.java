public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
            String a = Integer.toBinaryString(n);
        int count = a.length() - a.replace("1", "").length();
        return count;
    }
}