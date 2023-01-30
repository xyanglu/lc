class LFUCache {

    class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode prev = null;
        ListNode() {}    
        ListNode(int val, ListNode prev, ListNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
        }
    class LinkedList {
        ListNode left = new ListNode();
        ListNode right = new ListNode(0,left,null);
        Map<Integer,ListNode> map = new HashMap();
        
        LinkedList() {
                    left.next = right;
        }
        
        int length() {
            return map.size();
        }
        void pushRight(int val) {
            ListNode node = new ListNode(val,right.prev,right);
            map.put(val,node);
            right.prev = node;
            node.prev.next = node;
        }
        void pop(int val) {
            if ( map.containsKey(val) ) {
                ListNode node = map.get(val);
                ListNode next = node.next, prev = node.prev;
                next.prev = prev;
                prev.next = next;
                map.remove(val);
            }
        }
        int popLeft() {
           int res = left.next.val;
            pop(res);
            return res;
        }
        void update(int val) {
            pop(val);
            pushRight(val);
        }
    }
        
    
    int n = 0;
    int lfuCnt = 0;
    Map<Integer,Integer> valMap = new HashMap();
    Map<Integer,Integer> countMap = new HashMap();
    Map<Integer,LinkedList> listMap = new HashMap();
    public LFUCache(int capacity) {
        n = capacity;
    }
void counter(int key) {
    int cnt = countMap.getOrDefault(key,0);
    countMap.put(key,cnt+1);
    if ( !listMap.containsKey(cnt) )
        listMap.put(cnt,new LinkedList());
        listMap.get(cnt).pop(key);
    if ( !listMap.containsKey(cnt+1) )
        listMap.put(cnt+1,new LinkedList());
    listMap.get(cnt+1).pushRight(key);
    
    if ( listMap.containsKey(cnt) && listMap.get(cnt).length() == 0 && cnt == lfuCnt )
        lfuCnt++;
    
}
    
    public int get(int key) {
        if ( !valMap.containsKey(key) )
            return -1;
        
        counter(key);
        return valMap.get(key);
    }
    
    public void put(int key, int value) {
        if ( n == 0 ) return;
        
        if ( listMap.containsKey(lfuCnt) && !valMap.containsKey(key) && valMap.size() == n ) {
            int val = listMap.get(lfuCnt).popLeft();
            valMap.remove(val);
            countMap.remove(val);
        }
        
        valMap.put(key,value);
        counter(key);
        lfuCnt = Math.min(lfuCnt, countMap.get(key) );
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */