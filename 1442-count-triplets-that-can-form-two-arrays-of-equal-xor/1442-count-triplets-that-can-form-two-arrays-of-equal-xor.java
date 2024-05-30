class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int xor_ij = 0;
            for (int j = i; j < n; j++) {
                xor_ij ^= arr[j];
                int xor_jk = 0;
                for (int k = j + 1; k < n; k++) {
                    xor_jk ^= arr[k];
                    if (xor_ij == xor_jk) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
