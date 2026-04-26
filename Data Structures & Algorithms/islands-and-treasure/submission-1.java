class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i =0; i< rows; i++){
            for (int j=0; j < cols; j++){
                if (grid[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int level = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i < size; i++){
                int[] curr = queue.poll();
                for (int[] direction : directions){
                    int nr = direction[0] + curr[0];
                    int nc = direction[1] + curr[1];
                    if (nr >=0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 2147483647){
                        grid[nr][nc] = level;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
            level++;
        }
    }
}



// [
//   [INF,-1, 0,  INF],
//   [INF,INF,INF,-1],
//   [INF,-1, INF,-1],
//   [0  ,-1, INF,INF]
// ]