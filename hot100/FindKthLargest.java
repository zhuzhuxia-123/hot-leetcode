import java.lang.invoke.VarHandle;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            maxHeap.add(num);
        }
        int key = 0;
        while (k != 0) {
            key = maxHeap.poll();
            k--;
        }
        return key;
    }
}
