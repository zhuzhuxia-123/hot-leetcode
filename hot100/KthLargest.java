
import java.util.*;

public class KthLargest {
    //解法
    private int k;
    private PriorityQueue<Integer> minHeap;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int num : nums){
            addToHeap(num);
        }
    }

    public int add(int val) {
        addToHeap(val);
        return minHeap.peek();
    }

    private void addToHeap(int num){
        minHeap.add(num);
        while (minHeap.size() > k){
            minHeap.poll();
        }
    }
}
