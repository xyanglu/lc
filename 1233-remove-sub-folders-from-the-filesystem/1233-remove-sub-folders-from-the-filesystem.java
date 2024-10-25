class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> set = new HashSet();
        
        
        Arrays.sort(folder,(a,b)->a.length()-b.length());
        
        for ( String f : folder) {
            boolean match = false;

            for (String s : set) {
                if ( f.startsWith(s) ) 
                    match = true;
            }
            if ( !match ) 
                set.add(f+"/");
                
            
        }
        List<String> list = new ArrayList();
        for (String s : set)
            list.add( s.substring(0,s.length()-1));
        
        return list;
    }
}