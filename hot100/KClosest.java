import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class KClosest {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });
        for (int[] point : points) {
            int len = point[0] * point[0] + point[1] * point[1];
            if (maxHeap.size() == k) {
                if (maxHeap.peek()[2] > len) {
                    maxHeap.poll();
                    maxHeap.offer(new int[]{point[0], point[1], len});
                }
            } else {
                maxHeap.offer(new int[]{point[0], point[1], len});
            }
        }
        int[][] ans = new int[k][2];
        int index = 0;
        for (int[] ints : maxHeap) {
            ans[index] = Arrays.stream(ints).limit(2).toArray();
            index++;
        }
        return ans;
    }
}
