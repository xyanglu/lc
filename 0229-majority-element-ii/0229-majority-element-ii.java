class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        for (int n : nums)
            map.put(n,map.getOrDefault(n,0)+1);
        
        List<Integer> list = new ArrayList();
        for (int n : map.keySet()) 
            if ( map.get(n) > nums.length/3 ) 
                list.add(n);
        return list;
        
        
    }
}