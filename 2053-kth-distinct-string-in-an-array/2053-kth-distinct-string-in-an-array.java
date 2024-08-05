class Solution {
    public String kthDistinct(String[] arr, int k) {
        List<String> list = new ArrayList();
        Map<String,Integer> map = new HashMap();
        for (String s : arr)
        {
            if ( map.getOrDefault(s,0)>0  ) 
                map.put(s,map.get(s)+1);
            else {
                list.add(s);
                map.put(s,1);
            }
        }
        for ( String s: list) {
            if ( map.get(s) == 1 )
                if ( k-- == 1 )
                    return s;
        }
        return "";
    }
}