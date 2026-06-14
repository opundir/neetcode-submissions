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
        if(head==null || head.next==null) return head;
        ListNode temp = rev(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        // l1 = rev(l1);
        // l2 = rev(l2);
        int carry=0;
        while(l1!=null && l2!=null){
            ListNode curr = new ListNode((l1.val+l2.val+carry)%10);
            node.next = curr;
            node = node.next;
            carry = (l1.val+l2.val+carry)/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            ListNode curr = new ListNode((l1.val+carry)%10);
            node.next = curr;
            node = node.next;
            carry = (l1.val+carry)/10;
            l1 = l1.next;
        }

        while(l2!=null){
            ListNode curr = new ListNode((l2.val+carry)%10);
            node.next = curr;
            node = node.next;
            carry = (l2.val+carry)/10;
            l2 = l2.next;
        }
        if(carry>0){
            ListNode curr = new ListNode(1);
            node.next = curr;
            node = node.next;
        }
        return (dummy.next);

    }
}
