class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        
        for ( int candy : candies )
        {
            if (candy>max)
            {
                max = candy;
            }
        }
        
        List<Boolean> list = new ArrayList<Boolean>();
        
        for ( int candy : candies )
        {
            list.add( candy + extraCandies >= max );
         }
        
        return list;
    }
}