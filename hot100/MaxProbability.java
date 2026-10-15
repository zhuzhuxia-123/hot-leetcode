import java.util.*;

 class Pair implements Comparable<Pair> {
    double probability;
    int node;

    public Pair(double probability , int node){
        this.probability = probability;
        this.node = node;
    }

    @Override
    public int compareTo(Pair pair2) {
        if(this.probability == pair2.probability){
            return this.node - pair2.node;
        }else {
            return this.probability - pair2.probability > 0 ? -1 : 1;
        }
    }
}
public class MaxProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node){
        ArrayList<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Pair>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            graph.get(e[0]).add(new Pair(succProb[i],e[1]));
            graph.get(e[1]).add(new Pair(succProb[i],e[0]));
        }

        PriorityQueue<Pair> que = new PriorityQueue<>();
        double[] prob = new double[n];
        que.offer(new Pair(1,start_node));
        prob[start_node] = 1;
        while (!que.isEmpty()){
            Pair pair = que.poll();
            double pr = pair.probability;
            int node = pair.node;

            if(pr < prob[node]){
                continue;
            }

            for (Pair pairNext : graph.get(node)) {
                double prNext = pairNext.probability;
                int nodeNext = pairNext.node;

                if(prob[nodeNext] < prob[node] * prNext){
                    prob[nodeNext] = prob[node] * prNext;
                    que.offer(new Pair(prob[nodeNext],nodeNext));
                }
            }

        }
        return prob[end_node];
    }

   /* Deque<Double> stack = new ArrayDeque<>();
    double max_num = 0;
    boolean[] visited;

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // 起点就是终点，概率为1
        if(start_node == end_node){
            return 1.0;
        }
        double[][] matrix = new double[n][n];
        visited = new boolean[n];
        Arrays.fill(visited,false);
        int index  = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            matrix[u][v] = succProb[index];
            matrix[v][u] = succProb[index]; // 无向图双向赋值
            index++;
        }
        dfs(matrix,start_node,end_node,n);
        // 保留5位小数返回
        return Math.round(max_num * 100000.0) / 100000.0;
    }

    private void dfs(double[][] matrix, int startNode, int endNode,int n) {
        visited[startNode] = true;

        if(startNode == endNode){
            double product = 1.0;
            for (Double val : stack) {
                product *= val;
            }
            max_num = Math.max(max_num, product);
            visited[startNode] = false; // ✅回溯访问标记
            return;
        }

        // ✅i从0开始遍历所有节点，不是startNode
        for (int i = 0; i < n; i++) {
            // 没有边 || 已经访问，跳过
            if(!visited[i] && matrix[startNode][i] > 0){
                stack.offerLast(matrix[startNode][i]);
                dfs(matrix,i,endNode,n);
                stack.pollLast(); // 回溯弹出
            }
        }
        visited[startNode] = false; // ✅回溯
    }*/
}
