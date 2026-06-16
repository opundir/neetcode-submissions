/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(-1);
        Node node = head;
        Node temp = dummy;
        HashMap<Node, Node> m = new HashMap<>();
        while(node!=null){
            temp.next = new Node(node.val);
            temp = temp.next;
            m.put(node,temp);
            node =node.next;
        };
        node = head;
        temp = dummy.next;
        while(node!=null){
            m.get(node).random = m.get(node.random);
            node = node.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}
