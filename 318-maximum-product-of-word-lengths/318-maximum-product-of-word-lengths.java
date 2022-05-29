class Solution {
    public int maxProduct(String[] words) {
        int rc = 0;

        List<Set> list = new ArrayList();
        List<Integer> lists = new ArrayList();
        for ( String word : words) {
            Set<Character> set = new HashSet();
            for ( char c : word.toCharArray() )
                set.add(c);
            
            list.add(set);
            lists.add(word.length());
        }
        
        for (int i=0;i<list.size();i++) {
            Set<Character> set1 = list.get(i);
            for (int j=0;j<list.size();j++) {
                if ( i == j ) continue;
                Set<Character> set2 = list.get(j);
                boolean share = false;
                for ( char c : set1 )
                    if ( set2.contains(c) ) {
                        share = true;
                        break;
                    }
                if ( share ) continue;
                rc = Math.max(rc, lists.get(i) * lists.get(j) );
                        
            }
        }
        
        
        return rc;
    }
}