public class SwapPairs {
    // 设置前后指针来移动结点
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode l_node,f_node ;
        ListNode h_node = new ListNode();
        h_node.next = head;
        l_node = h_node;
        f_node = h_node.next;
        while (f_node != null){
            ListNode temp = f_node.next;
            if(temp==null){
                break;
            }else f_node.next = f_node.next.next;
            temp.next = l_node.next;
            l_node.next = temp;
           f_node = f_node.next;
            l_node = l_node.next.next;
        }
        return h_node.next;
    }
}
