class Node{
    Node next;
    Node prev;

    int key;
    int val;

    Node(int key,int val){
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int cap;
    HashMap<Integer,Node> m = new HashMap<>();
    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public void delete(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node){
        Node headNext = head.next;
        head.next = node;
        node.next = headNext;
        headNext.prev = node;
        node.prev = head;
    }
    public int get(int key) {
        if(m.containsKey(key)){
            Node node = m.get(key);
            delete(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(m.containsKey(key)){
            Node node = m.get(key);
            node.val = value;
            delete(node);
            insert(node);
            return;
        }

        if(m.size()==cap){
            Node nodetodlt = tail.prev;
            delete(nodetodlt);
            m.remove(nodetodlt.key);
        }

        Node newNode = new Node(key,value);
        insert(newNode);
        m.put(key,newNode);
    }
}
