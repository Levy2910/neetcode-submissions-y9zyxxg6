class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for (int i =0; i < adj.length; i++){
            adj[i] = new ArrayList<>();
        }
        for (int[] edge: edges){
            int edge1 = edge[0];
            int edge2 = edge[1];
            adj[edge1].add(edge2);
            adj[edge2].add(edge1);
        }
        if (!validTree(0, adj, visited, -1)){
            return false;
        }
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                return false;
            }
        }
        return true;
    }
    private boolean validTree(int curr, List<Integer>[] adj, boolean[] visited, int parent){
        visited[curr] = true;
        for (int neighbor : adj[curr]){
            if (!visited[neighbor]){
                if (!validTree(neighbor, adj, visited, curr)){
                    return false;
                }
            }else if (visited[neighbor] && neighbor != parent){
                return false;
            }
        }
        return true;
    }
}


// 0 ->{1, 2, 3}
// 1 ->{0, 4}
// 2 ->{0}
// 3->{0}
// 4->{1}

// 0 -> {1}
// 1 ->{2, 3, 4}
// 2 ->{1, 3}
// 3 -> {2, 1}
// 4 ->{1}
