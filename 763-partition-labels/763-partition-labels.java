class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] arr = new int[26];
        for (int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            arr[c-'a'] = i;
        }
        int j = 0;
        int start = 0;
        List<Integer> list = new ArrayList();
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            j = Math.max(j, arr[c-'a']);
            if ( i == j ) {
                list.add(i - start + 1);
                start = i + 1;
            }
        }
        return list;
    }
}