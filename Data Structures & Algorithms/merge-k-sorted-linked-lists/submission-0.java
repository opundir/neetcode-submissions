/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Pair{
    ListNode node;
    Integer val;
    Pair(ListNode node, Integer val){
        this.node = node;
        this.val = val;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b)->{
            return a.val - b.val;
        });

        for(ListNode node : lists){
            pq.add(new Pair(node, node.val));
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            temp.next = p.node;
            temp = temp.next;
            if(p.node.next!=null){
                pq.add(new Pair(p.node.next,p.node.next.val));
            }
        }
        return dummy.next;

    }
}
