class Solution {
    int[][] books = null;
    int shelf = 0;
    Map<Integer,Integer> map = new HashMap();
    public int minHeightShelves(int[][] books, int shelfWidth) {
        this.books = books;
        this.shelf = shelfWidth;
        return dfs(0);
    }
    int dfs(int i) {
        if ( i == books.length ) return 0;
        if ( map.containsKey(i) ) return map.get(i); 
        int max = 0;
        int remaining = shelf;
        // System.out.println(i);
        int rc = Integer.MAX_VALUE;
        int j = i;
        
        while ( i<books.length && remaining >= books[i][0] ) {
            max = Math.max(max,books[i][1]);
            remaining -= books[i][0];
            rc = Math.min(rc, max + dfs(i+1));
            i++;
        }
        
        map.put(j, rc);
        return map.get(j);
    }
}