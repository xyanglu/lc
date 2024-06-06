class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if ( hand.length % groupSize != 0 ) return false;
        Map<Integer,Integer> map = new TreeMap();
        for (int h : hand)
            map.put(h,map.getOrDefault(h,0)+1);
        
        Arrays.sort(hand);
        
        for (int j=hand.length-1;j>0;j--) {
            int prev = hand[j];
            if ( map.get(prev) == 0 ) continue;
            if ( map.containsKey(prev+1) && map.get(prev+1) > 0 ) continue;
            for (int i=0;i<groupSize;i++) {
                if (!map.containsKey(prev) || map.get(prev) == 0 ) return false;
                map.put(prev,map.get(prev)-1);
                prev--;
            }
        }
        return true;        
    }
}