class Solution {
    public boolean reorderedPowerOf2(int n) {
        if ( n == 1 ) return true;
        Set<String> set = new HashSet();
        int base = 2;
        while ( String.valueOf(base).length() <= String.valueOf(n).length() ) {
            String s = String.valueOf(base);
            char[] c = s.toCharArray();
            Arrays.sort(c);
            set.add(Arrays.toString(c));

            base *= 2;
        }
                    String s = String.valueOf(n);
            char[] c = s.toCharArray();
            Arrays.sort(c);
                    System.out.println(s+" "+Arrays.toString(c));
        return set.contains(Arrays.toString(c));
    }
}