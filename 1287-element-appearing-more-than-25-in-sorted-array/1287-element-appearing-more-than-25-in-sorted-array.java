class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap();
        for ( int a : arr ) {
            map.put(a,map.getOrDefault(a,0)+1);
            if ( map.get(a) > n/4 ) return a;
        }
        return -1;    
    }
}