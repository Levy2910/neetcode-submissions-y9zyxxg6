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
        if (detectCycle(adj, 0, -1, visited)){
            return false;
        }
        for (int i=0; i < n; i++){
            if (!visited[i]){
                return false;
            }
        }
        return true;
    }
    private boolean detectCycle(List<Integer>[] adj, int curr, int parent, boolean[] visited){
        visited[curr] = true;
        for (int neighbor : adj[curr]){
            if (neighbor != parent && visited[neighbor]){
                return true;
            }else if (neighbor != parent && !visited[neighbor]){
                if (detectCycle(adj, neighbor, curr, visited)) {
                    return true;
                }
            }else if (neighbor == parent){
                continue;
            }
        }
        return false;
    }
}
