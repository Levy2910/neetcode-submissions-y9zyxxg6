class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        int[] indegree = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i < adj.length; i++){
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];
            adj[node1].add(node2);
            adj[node2].add(node1);
            indegree[node1]++;
            indegree[node2]++;
        }
        for (int i=0; i < indegree.length; i++){
            if (indegree[i] == 1){
                queue.add(i);
            }
        }
        int remaining = n;
        while (remaining > 2){
            int size = queue.size();
            remaining -= size;
            for (int i =0; i < size; i++){
                int curr = queue.poll();
                indegree[curr]--;
                for (int neighbor : adj[curr]){
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 1){
                        queue.add(neighbor);
                    }
                }
            }
        }
        return queue.size() != 0 ? new ArrayList<>(queue) : new ArrayList<>(List.of(0));
    }
}

