import javax.swing.text.html.parser.Entity;
import java.util.*;

public class TopKFrequent {
    //使用map在内部遍历
    /*public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num , map.getOrDefault(num , 0)+1);
        }
        ArrayList<Map.Entry<Integer, Integer>> entryArrayList = new ArrayList<>(map.entrySet());
        Collections.sort(entryArrayList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int[] ans = new int[k];
        int index = 0;
        for (Map.Entry<Integer,Integer> en : entryArrayList){
            if(index == k) break;
            ans[index] = en.getKey();
            index++;
        }
        return ans;
    }*/

    //使用优先队列，在内部改变排序方法，注意可以存放多个int[]数组类型，指定排序方法
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            int key = en.getKey(), count = en.getValue();
            if (minHeap.size() == k) {
                if (count > minHeap.peek()[1]) {
                    minHeap.poll();
                    minHeap.offer(new int[]{key, count});
                }
            } else {
                minHeap.offer(new int[]{key, count});
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = minHeap.poll()[0];
        }
        return ans;
    }
}
