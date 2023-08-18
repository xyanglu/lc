class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer,Set<Integer>> map = new HashMap();
        for (int i=0;i<n;i++)
            map.put(i,new HashSet());
        for (int[] r : roads) {
            map.get(r[0]).add(r[1]);
            map.get(r[1]).add(r[0]);
        }
        
        int max = 0;
        for (int i=0;i<n;i++)
            for (int j=i+1;j<n;j++)
            {
                int a = map.get(i).size();
                int b = map.get(j).size();
                int cur = a+b;
                //System.out.println(i+" "+a+" "+j+" "+b);
                if ( map.get(j).contains(i) ) cur--;
                max = Math.max(cur,max);
            }
                
        return max;
        
    }
}