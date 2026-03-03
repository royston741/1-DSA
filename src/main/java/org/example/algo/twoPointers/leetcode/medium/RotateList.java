package org.example.algo.twoPointers.leetcode.medium;

// https://leetcode.com/problems/rotate-list/description/?envType=problem-list-v2&envId=two-pointers
public class RotateList {

    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // calculate the length and find the tail Node
        int length = 1;
        ListNode tailNode = head;
        while (tailNode.next != null) {
            tailNode = tailNode.next;
            length++;
        }
        /*
        k = k % length
        Rotating more than the list size repeats the list, so we keep only the remaining rotations.
        Example
        List = [0,1,2]
        length = 3
        k = 4

        k % length = 4 % 3 = 1
        ➡️Rotating 4 times is the same as rotating 1 time
        Result:
            [2, 0, 1]
        */


        k = k % length;

        //create a circular reference to the head
        tailNode.next = head;

        //find new tail
        int target = length - k;
        ListNode newTail = head;
        for (int i = 1; i < target; i++) {
            newTail = newTail.next;
        }
        // new head node
        ListNode newHead = newTail.next;

        //end the circular reference
        newTail.next = null;
        return newHead;
    }
}
