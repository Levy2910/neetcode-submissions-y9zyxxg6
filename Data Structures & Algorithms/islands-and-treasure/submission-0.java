class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i =0; i < rows; i++){
            for (int j =0; j < cols; j++){
                if (grid[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
            }
        }
        int level = 1;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i < size; i++){
                int[] currPair = queue.poll();
                for (int[] direction : directions){
                    int newRow = currPair[0] + direction[0];
                    int newCol = currPair[1] + direction[1];
                    if (newRow >=0 && newRow < rows && newCol >=0 && newCol < cols){
                        if (grid[newRow][newCol] == 2147483647){
                            queue.add(new int[]{newRow, newCol});
                            grid[newRow][newCol] = level;
                        }
                    }
                }
                
            }
            level++;
        }
    }
}
