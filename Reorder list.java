
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]


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
    public ListNode middleNode(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head)
    {
        ListNode prev=null;
        ListNode present=head;
        ListNode next=present.next;
        while(present!=null)
        {
            present.next=prev;
            prev=present;
            present=next;
            if(next!=null)
                next=next.next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode fh = head;
        ListNode sh = reverseList(mid);
        while(fh!=null && sh!=null)
        {
            ListNode temp=fh.next;
            fh.next=sh;
            fh=temp;
            
            temp=sh.next;
            sh.next=fh;
            sh=temp;
        }
        if(fh!=null)
            fh.next=null;
    }
}
