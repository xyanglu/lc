class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        
        List<String> list = new ArrayList();
        
        dfs(list,0,n,"");
        
        Set<String> set = new HashSet();
        for (String num : nums)
            set.add(num);
        
        for (String s: list)
            if ( !set.contains(s) )
                return s;
        return "";
    }
    void dfs(List<String> list, int i, int n, String s) {
        if ( i == n ) {
            list.add(s);
            return;
        }
        dfs(list,i+1,n,s+"0");
        dfs(list,i+1,n,s+"1");
        
        
        
        
    }
}