class Solution {
    public boolean canArrange(int[] arr, int k) {
        
        Map<Integer,Integer> map = new HashMap();
        
        for (int a : arr) {
            while ( a < 0 )
                a+=k;
            a = a % k;
            if ( map.containsKey(k-a) ) {
                map.put(k-a,map.get(k-a)-1);
                if ( map.get(k-a) == 0 )
                    map.remove(k-a);
            }
            else
                map.put(a, map.getOrDefault(a,0)+1);
        }
        
        System.out.println(map);
        if ( map.size() == 1 && map.containsKey( 0) && map.get(0) % 2 == 0 ) return true;
        return map.size() == 0;
        
    }
}