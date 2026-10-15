public class ReverseList {

//    [1,2,3,4,5]
//    [1] temp = 1
//    [2,1] temp = 2
    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode temp = null;
        while(node != null){
            ListNode next = node.next;
            node.next = temp;
            temp = node;
            node = next;
        }
        return temp;
    }


}


