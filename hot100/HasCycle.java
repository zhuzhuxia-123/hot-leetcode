public class HasCycle {
    public boolean hasCycle(ListNode head) {
        boolean flag = false;
        if(head == null || head.next==null){
            return flag;
        }
        //使用快慢指针的方法解决,快指针是慢指针的2倍，慢指针走一步，快指针走两步，有环则会相遇
        ListNode f_node = head.next;
        ListNode l_node = head;
        while (f_node != null){
            if(f_node == l_node){
                flag =true;
                break;
            }
            l_node = l_node.next;
            if(f_node.next != null){
                f_node = f_node.next.next;
            }else {
                f_node = null;
            }
        }
        return flag;
    }
}
