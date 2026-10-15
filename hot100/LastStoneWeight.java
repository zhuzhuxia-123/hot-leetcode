import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone:stones){
            minHeap.add(stone);
        }
        while (minHeap.size() > 1){
                int x = minHeap.poll();
                int y = minHeap.poll();
                if(x!=y){
                    minHeap.add(x-y);
                }
        }
        return minHeap.size() == 0?0:minHeap.peek();
    }
}
