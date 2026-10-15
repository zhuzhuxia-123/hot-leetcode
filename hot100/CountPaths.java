import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class CountPaths {
    public int countPaths(int n, int[][] roads) {
        ArrayList<List<Pair>> graph = new ArrayList<>();
        int mod = 1000000007;
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Pair>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(new Pair(road[2],road[1]));
            graph.get(road[1]).add(new Pair(road[2],road[0]));
        }
        long[] dis = new long[n];
        Arrays.fill(dis,Long.MAX_VALUE);
        int[] ways = new int[n];
        PriorityQueue<Pair> que = new PriorityQueue<>();
        que.offer(new Pair(0,0));
        dis[0] = 0;
        ways[0] = 1;
        while (!que.isEmpty()){
            Pair poll = que.poll();
            long weight = poll.weight;
            int node = poll.node;
            if(weight > dis[node]){
                continue;
            }
            for (Pair pair : graph.get(node)) {
                long prNext = pair.weight;
                int nodeNext = pair.node;
                if(dis[nodeNext] > weight + prNext){
                    dis[nodeNext] = weight + prNext;
                    ways[nodeNext] = ways[node];
                    que.offer(new Pair(weight+prNext,nodeNext));
                }else if(weight+prNext == dis[nodeNext]){
                    ways[nodeNext] = (ways[nodeNext] + ways[node])%mod;
                }
            }
        }
        return ways[n-1];
    }
}
class Pair implements Comparable<Pair>{
    long weight;
    int node;
    public Pair(long weight , int node){
        this.weight = weight;
        this.node = node;
    }
    @Override
    public int compareTo(Pair pair) {
        if(this.weight == pair.weight){
            return 0;
        }else {
            return this.weight - pair.weight > 0 ? 1 : -1;
        }
    }
}