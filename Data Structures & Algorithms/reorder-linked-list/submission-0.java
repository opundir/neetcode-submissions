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

class Solution {
    public ListNode rev(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode reverse = rev(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;
    }
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = rev(slow.next);
        slow.next = null;
        slow = head;
        fast = head2;
        while(slow!=null && fast!=null){
            ListNode next = slow.next;
            slow.next = fast;
            slow = next;
            ListNode fastnext = fast.next;
            fast.next = next;
            fast = fastnext;
        }
    }
}
