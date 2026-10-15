import java.util.jar.JarEntry;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int node_sum = 0;
        ListNode node = head;
        while (node!=null){
            node_sum++;
            node = node.next;
        }
        ListNode h_node = new ListNode();
        h_node.next =head;
        node = h_node;
        //删除倒数第n个，就是正数第node_sum - n个后面的元素
        int count = node_sum -n;
        while(count>0){
            node = node.next;
            count--;
        }
        node.next =node.next.next;
        return h_node.next;
    }
}
