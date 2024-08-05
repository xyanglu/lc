class Solution {
    public String kthDistinct(String[] arr, int k) {
        Set<String> set = new LinkedHashSet();
        Set<String> seen = new HashSet();
        for ( String s : arr) {
            if ( set.contains(s) || seen.contains(s) ) {
                set.remove(s);
                seen.add(s);
                continue;
            }
            set.add(s);
        }
        if ( set.size() < k ) return "";
        for (String s : set)
            if ( k-- == 1 )
                return s;
        return "";
    }
}