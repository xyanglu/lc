class Solution {
    public boolean detectCapitalUse(String word) {
        if ( word.toUpperCase().equals(word) ) return true;
        if ( word.toLowerCase().equals(word) ) return true;
        if ( word.length() == 1 ) return true;
        if ( Character.isUpperCase(word.charAt(0)) && word.substring(1,word.length()).equals(word.substring(1,word.length()).toLowerCase())) return true;
        
        
        return false;
    
    }
}