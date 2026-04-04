class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        for (int i=0; i < parent.length; i++){
            parent[i] = i;
        }
        for (int[] edge : edges){
            if (union(edge[0], edge[1], parent)){
                return new int[]{edge[0], edge[1]};
            }
        }
        return new int[0];
    }
    private int find(int x, int[] parent){
        if (parent[x] != x){
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
    private boolean union(int x, int y, int[] parent){
        int rootA = find(x, parent);
        int rootB = find(y, parent);
        if (rootA == rootB){
            return true;
        }
        parent[rootA] = rootB;
        return false;
    }
}
