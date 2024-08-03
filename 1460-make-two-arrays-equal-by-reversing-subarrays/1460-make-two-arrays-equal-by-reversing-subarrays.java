class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer,Integer> map = new HashMap();
        for (int t : target)
            map.put(t,map.getOrDefault(t,0)+1);
        for (int a : arr) {
            if ( map.getOrDefault(a,0) < 1 ) return false;
            map.put(a,map.get(a)-1);
        }
        return true;
    }
}