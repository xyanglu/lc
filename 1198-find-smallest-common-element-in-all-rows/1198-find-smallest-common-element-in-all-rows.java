class Solution {
    public int smallestCommonElement(int[][] mat) {
        Map<Integer,Integer> map = new TreeMap();
        for (int i=0;i<mat.length;i++)
            for (int j : mat[i])
                map.put(j,map.getOrDefault(j,0)+1);
        
        for (int key : map.keySet()) 
            if ( map.get(key) == mat.length )
                return key;
        return -1;
    }
}