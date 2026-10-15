public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode constructList(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode preNode = dummy;
        for (int i = 0; i < nums.length; i ++) {
            ListNode currNode = new ListNode(nums[i]);
            preNode.next = currNode;
            preNode = preNode.next;
        }
        return dummy.next;
    }
}
