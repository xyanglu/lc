class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        
        while (  word.length() != 0 ) {
            char c = word.charAt(0);
            int len = 1;
            while ( len < 9 && len < word.length() && word.charAt(len) == c ) len++;
            sb.append(len+""+c);
            word = word.substring(len,word.length());
        }
        
        return sb.toString();
    }
}