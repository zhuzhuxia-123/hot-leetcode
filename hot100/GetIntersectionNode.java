public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB==null){
            return null;
        }
        ListNode key_node = null;
        int A_num =0 , B_num = 0;
        ListNode A_node = headA , B_node = headB;
        while (A_node!=null){
            A_node = A_node.next;
            A_num++;
        }
        while (B_node!=null){
            B_node=B_node.next;
            B_num++;
        }
        int num = A_num>=B_num?A_num-B_num:B_num-A_num;
        if (A_num > B_num){
            while (num!=0) {
                headA = headA.next;
                num--;
            }
        }else if (B_num > A_num){
            while (num!=0){
                headB = headB.next;
                num--;
            }
        }
        while (headA!=null&&headB!=null){
            if(headA == headB){
                key_node = headA;
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return key_node;
    }
}
