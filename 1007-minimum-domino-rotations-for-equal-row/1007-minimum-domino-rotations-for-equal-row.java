class Solution {
    public int minDominoRotations(int[] t, int[] b) {
        Map<Integer,Integer> top = new HashMap();
        Map<Integer,Integer> bot = new HashMap();
        int[] free = new int[7];
        
        for (int i=0;i<t.length;i++) {
            if ( t[i] == b[i] ) {
                free[ t[i]]++;
                continue;
            }
            top.put(t[i],top.getOrDefault(t[i],0)+1);
            bot.put(b[i],bot.getOrDefault(b[i],0)+1);
        }
        
        int min = Integer.MAX_VALUE;
        for (int i=1;i<=6;i++) {
            int T = top.getOrDefault(i,0);
            int B = bot.getOrDefault(i,0);
            
            if ( free[i] + T + B >= t.length ) 
                min = Math.min(min, t.length - free[i] - Math.max(T,B));
        }
        return min == Integer.MAX_VALUE ? - 1 : min;
    }
}