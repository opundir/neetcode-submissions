class Node{
    int val;
    int key;
    Node next;
    Node prev;
    Node(int key,int val){
        this.val = val;
        this.key = key;
        next = next = null;
        prev = null;
    }
}
class LRUCache {
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int size;
    HashMap<Integer,Node> m;
    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        size = capacity;
        m = new HashMap<>();
    }
    
    public int get(int key) {
        if(m.containsKey(key)){
            int val = m.get(key).val;
            Node node = m.get(key);
            delete(node);
            add(node);
            return val;
        }
        return -1;

    }
    
    public void put(int key, int value) {
        if(m.containsKey(key)){
            Node node = m.get(key);
            m.remove(node.key);
            delete(node);
        }
        if(m.size()==size){
            Node node = tail.prev;
            delete(node);
            m.remove(node.key);
        }
        Node newNode = new Node(key,value);
        add(newNode);
        m.put(key,newNode);
    }
    public void delete(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev=prev;
    }
    public void add(Node node){
        Node headnext = head.next;
        head.next = node;
        node.next = headnext;
        headnext.prev = node;
        node.prev = head;
    }
}
