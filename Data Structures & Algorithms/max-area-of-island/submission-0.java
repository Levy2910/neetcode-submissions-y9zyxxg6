class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int max = 0;

        for (int i=0; i < rows; i++){
            for (int j=0; j < cols; j++){
                if (!visited[i][j]){
                    int curr = dfs(i, j, grid, visited);
                    max = Math.max(max, curr);
                }
            }
        }
        return max;
    }
    private int dfs(int r, int c, int[][] grid, boolean[][] visited){
        if (r >= grid.length || r < 0 || c >= grid[0].length || c < 0 || grid[r][c] == 0 || visited[r][c]){
            return 0;
        }
        visited[r][c] = true;
        return 1 
        + dfs(r+1, c, grid, visited)
        + dfs(r-1, c, grid, visited)
        + dfs(r, c+1, grid, visited)
        + dfs(r, c-1, grid, visited);
    }
}
