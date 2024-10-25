class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> set = new HashSet();
        for (String f : folder)
            set.add(f);
        
                List<String> list = new ArrayList();
        for ( String f : folder) {
            list.add(f);
            for (int i=0;i<f.length();i++)
                if ( f.charAt(i) == '/' && set.contains(f.substring(0,i) ) )
                {
                    list.remove(f);
                    break;
                }
                    

        }

        
        return list;
    }
}