class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] split = sentence.split(" ");
        int n = split.length;
        if ( split[n-1].charAt( split[n-1].length()-1) != split[0].charAt(0) ) return false;
        
        for (int i=1;i<n;i++) {
            if ( split[i-1].charAt( split[i-1].length()-1) != split[i].charAt(0) ) return false;
        }
        return true;
    }
}