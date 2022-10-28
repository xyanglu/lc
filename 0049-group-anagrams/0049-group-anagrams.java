class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList();
        Map<String,List> map = new HashMap();
        for ( String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if (!map.containsKey(key)) 
                map.put(key,new ArrayList());
            map.get(key).add(str);
            
        }
        
        for ( List l : map.values() )
            list.add(l);
        
        return list;
    }
}