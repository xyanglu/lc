class Solution {
    public int maxOperations(int[] nums, int k) {
        int res = 0;
        
        Map<Integer,Integer> map = new HashMap();
        Set<Integer> set = new HashSet();
        for (int n : nums) {
            map.put(n,map.getOrDefault(n,0)+1);
            set.add(n);
        }
        
        for (int n : set) {
            if ( n * 2 == k ) {
                if ( map.get(n) > 1 ) 
                    res += map.get(n)/2;
            }
            else {
                int x = n;
                int y = k - n;
                int occ = Math.min( map.getOrDefault(x,0), map.getOrDefault(y,0) );
                map.put(x,map.getOrDefault(x,0)-occ);
                map.put(y,map.getOrDefault(y,0)-occ);
                res += occ;
            }
        }
        
        
        return res;
    }
}