class Solution {
    public int minSetSize(int[] arr) {
        int rc = 0;
        Map<Integer,Integer> map = new HashMap();
        int total = arr.length;
        for (int a : arr) {
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int half = total;
        System.out.println(total);
        Queue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>( (a,b) -> b.getValue() - a.getValue() );
        queue.addAll(map.entrySet());
        while ( !queue.isEmpty() && half > total/2 ) {
            Map.Entry<Integer,Integer> entry = queue.poll();
            half -= entry.getValue();
            //System.out.println(half + " "+entry.getKey() + " " +entry.getValue());
            rc++;
        }
        return rc;
    }
}