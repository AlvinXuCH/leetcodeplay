package leetcodetest;

/**
 * Created by shunhe on 2021/3/15.
 */
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result;
        ListNode temp = new ListNode();
        result = temp;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int num = l1.getVal() + l2.getVal() + carry;
            carry = num / 10;
            int newVal = carry == 1 ? num - 10 : num;
            temp.next = new ListNode(newVal);
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            if (carry == 0) {
                temp.next = l1;
                break;
            } else {
                temp.next = new ListNode((l1.getVal() + carry) % 10);
                carry = (l1.val + carry) / 10;
                temp = temp.next;
                l1 = l1.next;

            }
        }

        while (l2 != null) {
            if (carry == 0) {
                temp.next = l2;
                break;
            } else {
                temp.next = new ListNode((l2.getVal() + carry) % 10);
                carry = (l2.val + carry) / 10;
                temp = temp.next;
                l2 = l2.next;
            }
        }

        if(carry ==1){
            temp.next = new ListNode(1);
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(6);
//        ListNode node6 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        node4.next = null;
//        node5.next = null;
//        node5.next = node6;
//        node6.next = null;

        addTwoNumbers(node1, node4);

    }
}
