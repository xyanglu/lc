class Solution {
    public int countHomogenous(String s) {
        int rc = 0;
        char prev = 'A';
        int count = 0;
        int mod = 1000000007;  // Modulus value

        for (char c : s.toCharArray()) {
            if (prev != c)
                count = 0;
            prev = c;
            count++;
            rc = (rc + count) % mod;  // Apply modulus operation here
        }

        return rc;
    }
}
