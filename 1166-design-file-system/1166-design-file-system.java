class FileSystem {

    Map<String,Integer> map = new HashMap();
    
    public FileSystem() {
        map.put("",-1);
    }
    
    public boolean createPath(String path, int value) {
      int idx = path.lastIndexOf("/");
        String parent = path.substring(0, idx);
        if ( !map.containsKey(parent)) return false;
        if ( map.containsKey(path) )
            return false;
        
        map.put(path,value);
        return true;
    }
    
    public int get(String path) {
        return map.getOrDefault(path,-1);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */