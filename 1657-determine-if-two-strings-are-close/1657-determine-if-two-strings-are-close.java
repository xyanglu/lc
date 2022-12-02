class Solution {
    public boolean closeStrings(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        Arrays.sort(arr1);
        char[] arr2 = word2.toCharArray();
        Arrays.sort(arr2);
        
        if ( dfs(arr1,arr2) )
            return true;
        
        Set<Character> set1 = new HashSet();
        Map<Character,Integer> map = new HashMap();
        for ( char c : word1.toCharArray() ) {            map.put(c,map.getOrDefault(c,0)+1);
                                         set1.add(c);
                                             }
        
        arr1 = new char[map.size()];
        int i =0;
        for ( int val : map.values() )
            arr1[i++] = (char) (val+'0');
                Arrays.sort(arr1);

        map.clear();
        i = 0;
        Set<Character> set2 = new HashSet();
       for ( char c : word2.toCharArray() ) {
            map.put(c,map.getOrDefault(c,0)+1);
            set2.add(c);
       }
        
                arr2 = new char[map.size()];

        for ( int val : map.values() )
            arr2[i++] = (char) (val+'0');
        Arrays.sort(arr2);
        
        //System.out.println(arr1);
        //System.out.println(arr2);
        if ( set1.equals(set2) && dfs(arr1,arr2) )
            return true;
        
        return false; 
    }
    boolean dfs(char[] arr1, char[] arr2) {
        if ( arr1.length != arr2.length ) return false;
        for (int i=0;i<arr1.length;i++)
            if ( arr1[i] != arr2[i] )
                return false;
            
        return true;
    }
}