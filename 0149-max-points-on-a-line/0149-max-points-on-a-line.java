class Solution {
    public int maxPoints(int[][] points) {
        int max = 1;
        
        for (int i=0;i<points.length;i++) {
                    Map<Double,Integer> map = new HashMap();

            for (int j=i+1;j<points.length;j++)
            {
                int[] p = points[i];
                int[] p1 = points[j];
                double val = Integer.MAX_VALUE;
                if ( p1[0] - p[0] != 0 ) 
                    val = (double) (p1[1] - p[1]) / (double) (p1[0] - p[0]);
                //System.out.println(Arrays.toString(p)+" "+Arrays.toString(p1)+" "+(val));
                if ( val == -0f) val = 0;
                map.put(val,map.getOrDefault(val,0)+1);
                max = Math.max(max,map.get(val)+1);
            }
        }
        return max;
    }
}