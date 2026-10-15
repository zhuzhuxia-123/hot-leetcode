public class AddTwoNumbers {
    //解法：每一位相加，进位则保存给下一位相加的节点
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        int jin_num = 0;
        while (l1!=null&&l2!=null){
            int num = l1.val + l2.val+jin_num;
            int ge_num = num %10;
            jin_num = num /10;
            ListNode node = new ListNode(ge_num);
            node.next =temp.next;
            temp.next =node;
            temp = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1!=null){
            int num = l1.val +jin_num;
            int ge_num = num %10;
            jin_num = num /10;
            ListNode node = new ListNode(ge_num);
            node.next =temp.next;
            temp.next =node;
            temp = node;
            l1 = l1.next;
        }
        while (l2!=null){
            int num =l2.val+jin_num;
            int ge_num = num %10;
            jin_num = num /10;
            ListNode node = new ListNode(ge_num);
            node.next =temp.next;
            temp.next =node;
            temp = node;
            l2 = l2.next;
        }
        if(jin_num!=0){
            ListNode node = new ListNode(jin_num);
            node.next =temp.next;
            temp.next =node;
        }
        return head.next;
    }
}
