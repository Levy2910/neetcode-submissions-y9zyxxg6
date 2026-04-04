class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        if (grid[0][0] != 0 || grid[rows-1][cols-1] != 0){
            return -1;
        }
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int level = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i < size; i++){
                int[] curr = queue.poll();
                if (curr[0] == rows-1 && curr[1] == cols-1){
                    return level;
                }
                for (int[] direction : directions){
                    int nr = direction[0] + curr[0];
                    int nc = direction[1] + curr[1];
                    if (nr < rows && nr >=0 && nc < cols && nc >=0){
                        if (grid[nr][nc] == 0 && !visited[nr][nc]){
                            queue.add(new int[]{nr, nc});
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}

