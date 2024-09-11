class Solution {
    public int minBitFlips(int start, int goal) {
        String S = Integer.toBinaryString(start);
        String G = Integer.toBinaryString(goal);
        
        StringBuilder sb = new StringBuilder(S);
        sb.reverse();
        
        StringBuilder sg = new StringBuilder(G);
        sg.reverse();
        
        int rc = 0;
        
        for (int i=0;i<Math.max(sg.length(),sb.length());i++) {
            int b = i<sb.length()?sb.charAt(i)-'0':0;
            int g = i<sg.length()?sg.charAt(i)-'0':0;
            rc += b ^ g;
        }
        
        return rc;
        
        
    }
}