class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> map = new HashMap();
        for (int t : tasks)
            map.put(t,map.getOrDefault(t,0)+1);
        
        int rc = 0;
        for ( int key : map.keySet() ) {
            while ( map.get(key) > 0 ) {
                if ( map.get(key) == 1 ) return -1;
if ( map.get(key) % 3 == 0 ) 
{
                                     map.put(key,map.get(key)-3);
                    rc++;
                }
                else if ( map.get(key) % 2 == 0 ) {
                    map.put(key,map.get(key)-2);
                    rc++;
                }
                else
                {
                                     map.put(key,map.get(key)-3);
                    rc++;
                }
            }
        }
        return rc;
    }
}