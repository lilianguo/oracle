class CopyListWithRandomPointer {
    // 138
    class Node {
        public int val;
        public Node next;
        public Node random;
    
        public Node() {}
    
        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // map of oldNode to newNode
        // copy each node
        Map<Node, Node> map = new HashMap<>();
        Node oldNode = head;
        Node newNode = new Node(oldNode.val);
        map.put(oldNode, newNode);
        while (oldNode != null) {
            newNode.next = getClone(oldNode.next, map);
            newNode.random = getClone(oldNode.random, map);
            newNode = newNode.next;
            oldNode = oldNode.next;
        }
        return map.get(head);
    }

    private Node getClone(Node node, Map<Node, Node> map) {
        if (node == null) {
            return null;
        }
        if (!map.containsKey(node)) {
            map.put(node, new Node(node.val));
        }
        return map.get(node);
    }
}