class Trie {
    Map<String,Trie> children = new HashMap();
    boolean end_of_folder = false;
    
    void add(String path) {
        Trie cur = this;
        for (String f : path.split("/")) {
            if ( !cur.children.containsKey(f) )
                cur.children.put(f, new Trie());
            cur = cur.children.get(f);
        }
        cur.end_of_folder = true;
    }
    
    boolean prefix_search(String path) {
        Trie cur = this;
        String[] folders = path.split("/");
        for (int i=0;i<folders.length-1;i++) {
            cur = cur.children.get( folders[i]);
            if ( cur.end_of_folder ) 
                return true;
        }
        return false;
        
    }
    
}

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Trie trie = new Trie();
        
        for ( String f: folder)
            trie.add(f);
        
        List<String> res = new ArrayList();
        
        for (String f : folder)
            if ( !trie.prefix_search(f) )
                res.add(f);
        
        return res;
    }
}