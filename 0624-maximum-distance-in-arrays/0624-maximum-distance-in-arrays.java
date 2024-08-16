class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int rc = 0;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get( arrays.get(0).size() - 1 );
        for (int i=1;i<arrays.size();i++) {
            int n = arrays.get(i).size();
            rc = Math.max( rc, Math.max(Math.abs(max-arrays.get(i).get(0)),Math.abs(arrays.get(i).get(n-1)-min)));
            min = Math.min(min,arrays.get(i).get(0));
            max = Math.max(max,arrays.get(i).get(n-1));
        }
        return rc;
    }
}