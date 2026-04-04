class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i=0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];
            adj[node1].add(node2);
            adj[node2].add(node1);
        }
        boolean[] visited = new boolean[n];
        boolean result = false;
        if (!hasCycle(adj, 0, -1, visited)){
            result = true;
        }
        for (int i=0; i < n; i++){
            if (!visited[i]){
                return false;
            }
        }

        return result;
    }

    private boolean hasCycle(List<Integer>[] adj, int curr, int parent, boolean[] visited){
        visited[curr] = true;
        for (int neighbor : adj[curr]){
            if (!visited[neighbor]){
                if (hasCycle(adj, neighbor, curr, visited)){
                    return true;
                }
            }else if (neighbor != parent){
                return true;
            }
        }
        return false;
    }
}
// 0 -> {1}
// 1 -> {0, 2, 3, 4}
// 2 -> {1, 3}
// 3 -> {2, 1}
// 4 -> {1}
