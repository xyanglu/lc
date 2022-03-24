class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList();
        Map<String,List<String>> map = new HashMap();
        for ( String str : strs ) 
        {
            int[] key = new int[26];
            for ( char c : str.toCharArray() )
                key[c-'a']++;
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<26;i++)
                if ( key[i] != 0)
                    sb.append(key[i]+" "+i);
            
            if ( !map.containsKey(sb.toString()) )
                map.put(sb.toString(), new ArrayList());
            map.get(sb.toString()).add(str);
        }
        
        for ( List<String> values : map.values() ) {
            list.add(values);
        }
        
        return list;
    }
}