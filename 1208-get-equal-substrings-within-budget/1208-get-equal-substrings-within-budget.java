class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] arr = new int[s.length()];
        for (int i=0;i<s.length();i++) {
            arr[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        
        int j = 0;
        int cur = 0;
        int cost = 0;
        int max = 0;
        for (int i=0;i<s.length();i++) {
            cost += arr[i];
            cur++;
            while ( j <= i && cost > maxCost) {
                cost -= arr[j++];
                cur--;
            }
            
            if ( cost <= maxCost) {
                max = Math.max(cur,max);
            }
        }
        return max;
        
    }
}