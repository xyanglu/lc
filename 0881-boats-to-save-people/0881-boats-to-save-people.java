class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int i = 0, j = people.length-1;
        int k = 0;
        while ( i <= j ) {
            int lim = limit - people[j--];
            k++;
            if ( i <= j && people[i] <= lim ) {
                i++;
            }
        }
        return k;
    }
}