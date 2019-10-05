/*
146. LRU Cache
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

*/
class LRUCache {
    class ListNode {
        int key, val;
        ListNode next;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }
    private int capacity, size;
    private ListNode dummy, tail;
    private Map<Integer, ListNode> keyToPrev;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.dummy = new ListNode(0,0);
        this.tail = this.dummy;
        this.keyToPrev = new HashMap<>();
    }
    public int get(int key) {
        if (!keyToPrev.containsKey(key)) {
            return -1;
        }
        moveToTail(key);
        return tail.val;
    }
    
    public void put(int key, int value) {
        if (get(key) != -1) {
            ListNode prev = keyToPrev.get(key);
            prev.next.val = value;
            return;
        }
        if (size < capacity) {
            size++;
            ListNode curr = new ListNode(key, value);
            tail.next = curr;
            keyToPrev.put(key, tail);
            tail = tail.next;
            return;
        }
        
        // remove the first node, replace it with input node
        
        // Node to be replaced
        ListNode first = dummy.next;
        keyToPrev.remove(first.key);
        first.key = key;
        first.val = value;
        keyToPrev.put(first.key, dummy);
        
        // after replace, put it to the tail because it's the most recent one
        moveToTail(key);
        return;
    }

    private void moveToTail(int key) {
        ListNode prev = keyToPrev.get(key);
        ListNode curr = prev.next;
        if (curr == tail) {
            return;
        }
        prev.next = prev.next.next;
        tail.next = curr;
        if (prev.next != null) {
            keyToPrev.put(prev.next.key, prev);
        }
        keyToPrev.put(curr.key, tail);
        tail = curr;
        
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */