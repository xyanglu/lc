class Solution {
    public int[] findArray(int[] pref) {
        int[] arr = new int[pref.length];
        int temp = pref[0];
        arr[0] = temp;
        for (int i=1;i<pref.length;i++) {
            arr[i] = pref[i] ^ pref[i-1];
        }
        
        return arr;
    }
}