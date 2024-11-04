class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        while (  j < word.length() ) {
            char c = word.charAt(j);
            int len = 1;
            while ( len < 9 && len + j < word.length() && word.charAt(len+j) == c ) len++;
            sb.append(len+""+c);
            j+=len;
        }
        
        return sb.toString();
    }
}