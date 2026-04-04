class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int count =0;
        for (int i=0; i < parent.length; i++){
            parent[i] = i;
        }
        for (int[] edge : edges){
            union(edge[0], edge[1], parent);
        }
        for (int i=0; i < parent.length; i++){
            if (parent[i] == i){
                count++;
            }
        }
        return count;
    }
    private int find(int x, int[] parent){
        if (x != parent[x]){
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
    private void union(int x, int y, int[] parent){
        int rootA = find(x, parent);
        int rootB = find(y, parent);
        if (rootA == rootB){
            return;
        }
        parent[rootA] = rootB;
    }
}
