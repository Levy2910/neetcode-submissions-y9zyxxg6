class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        for (int i=0; i < parent.length; i++){
            parent[i] = i;
        }
        for (int[] edge : edges){
            if (union(edge[0], edge[1], parent)){
                return edge;
            }
        }
        return new int[]{0};
    }
    private int find(int x, int[] parent){
        if(x != parent[x]){
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
    private boolean union(int x, int y, int[] parent){
        int rootx = find(x, parent);
        int rooty = find(y, parent);
        if (rootx == rooty){
            return true;
        }
        parent[rootx] = rooty;
        return false;
    }
    
}
