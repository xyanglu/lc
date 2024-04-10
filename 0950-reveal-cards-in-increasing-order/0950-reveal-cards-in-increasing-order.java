class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;

        Arrays.sort(deck);
        
        List<Integer> list = new ArrayList();
        for (int i=n-1;i>=0;i--) {
            List<Integer> temp = new ArrayList(list);
            list.clear();
            int j = temp.size() - 1;
            list.add(0,i);
            if ( j >= 0 )
                list.add(temp.get(j--));
            for (j=j;j>=0;j--)
                list.add(2,temp.get(j));
            // System.out.println(list);
        }
        
        int[] rc = new int[n];
        for (int i=0;i<n;i++)
            rc[i] = deck[list.get(i)];
        return rc;
        
        
    }
}