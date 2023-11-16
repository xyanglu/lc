class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        
        Set<String> set = new HashSet();
        
        dfs(set,0,n,"");
        
        for (String num : nums)
            set.remove(num);
        
        for (String s: set)
            return s;
        return "";
    }
    void dfs(Set<String> list, int i, int n, String s) {
        if ( i == n ) {
            list.add(s);
            return;
        }
        dfs(list,i+1,n,s+"0");
        dfs(list,i+1,n,s+"1");
        
        
        
        
    }
}