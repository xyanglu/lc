class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int[] arr = new int[52];
        for ( char c : letters) {
            arr[c-'a']++;
            arr[c-'a'+26]++;
        }
        int i = (int) (target - 'a') + 1;
        while ( arr[i] == 0 )
            i++;
        return (char) (i%26 + 'a');
    }
}