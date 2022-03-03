class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap();
        for (int i=0;i<numCourses;i++)
            map.put(i,new ArrayList());
        
        for (int[] p : prerequisites)
            map.get(p[0]).add(p[1]);
        
        
        for (int i=0;i<numCourses;i++)
            if (!canFinish(i,map, new HashSet()))
                return false;
        
        return true;
    }
    boolean canFinish(int i,   Map<Integer,List<Integer>> map, Set<Integer> visited ) {
        if ( visited.contains(i) ) return false;
        
        visited.add(i);
        for (int neigh : map.get(i) )
            if ( !canFinish(neigh,map,visited) )
                return false;
        
        map.put(i, new ArrayList());  
        visited.remove(i);
        return true;
    }
}