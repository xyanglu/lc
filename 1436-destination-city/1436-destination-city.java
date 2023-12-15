class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String,Integer> map = new HashMap();
        for (List<String> l : paths)
            map.put(l.get(1),map.getOrDefault(l.get(1),0)+1);
        
        for (List<String> l : paths)
        {
            map.remove(l.get(0));
        }
        
        for ( String key : map.keySet())
            return key;
        
        return "";
    }
}