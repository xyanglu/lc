class Solution {
    Set<String> set = new HashSet();
    Set<String> match = new HashSet();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        for ( String w : words)
            set.add(w);
        for ( String w : words)
            if ( dfs(w) )
                match.add(w);
        
        return new ArrayList(match);
    }
    boolean dfs(String s) {
        for (int i=1;i<s.length();i++) {
            String pre = s.substring(0,i);
            String suf = s.substring(i,s.length());
            if ( set.contains(suf) && set.contains(pre) )
                return true;
            if ( set.contains(suf) && dfs(pre) )
                return true;
            
        }
        return false;
        
        
    }
}