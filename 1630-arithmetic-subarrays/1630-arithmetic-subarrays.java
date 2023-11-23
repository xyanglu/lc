class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList();
        
        for (int i=0;i<l.length;i++) {
            int L = l[i];
            int R = r[i];
            if ( L == R ) {
                list.add(false);
                continue;
            }
            Queue<Integer> queue = new PriorityQueue<>();
            for (int j=L;j<=R;j++)
                queue.add(nums[j]);
            System.out.println(queue);
            int prev = queue.poll();
            int diff = queue.poll() - prev;
            prev = diff + prev;
            
            boolean same = true;
            while ( !queue.isEmpty() ) {
                //System.out.println(queue.peek()+" "+diff);
                if ( queue.peek() - prev != diff )
                {
                    same = false;
                    break;
                }
                prev = queue.poll();
            }
            list.add(same);   
        }  
        
        return list;
    }
}