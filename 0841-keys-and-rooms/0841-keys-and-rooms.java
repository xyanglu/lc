class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet();
        
        dfs(0,rooms,set);
        
        
        
        return set.size() == rooms.size();
    }
    void dfs(int room, List<List<Integer>> rooms, Set<Integer> set) {
        if ( set.contains(room) ) return;
        set.add(room);
        
        for (int neigh : rooms.get(room) )
            dfs(neigh,rooms,set);
        
    }
}