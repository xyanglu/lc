class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        Map<Integer,Integer> map = new HashMap();
        for ( int s : students)
            map.put(s,map.getOrDefault(s,0)+1);
        
        for (int s : sandwiches) {
            if ( map.containsKey(s) && map.get(s) > 0 ) {
                n--;
                map.put(s,map.get(s)-1);
            }
            else
                return n;
        }
        return n;
    }
}