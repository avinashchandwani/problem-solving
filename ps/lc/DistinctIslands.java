class DistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        Set<String> uniqueKeys = new HashSet<>();
        for(int r = 0; r < grid.length; r++) {
            for(int c =0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    StringBuilder key = new StringBuilder();
                    computeDistinctIslands(grid, key, r, c, r, c);
                    uniqueKeys.add(key.toString());
                }
            }
        }
        return uniqueKeys.size();
    }
    
    private void computeDistinctIslands(int [][]grid, StringBuilder key, int r, int c, int startR, int startC) {
        if(r <0 || r >=grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0){
            return;
        }
        key.append(startR - r);
        key.append(startC - c);
        grid[r][c] = 0;
        computeDistinctIslands(grid, key, r + 1, c, startR, startC);
        computeDistinctIslands(grid, key, r - 1, c, startR, startC);
        computeDistinctIslands(grid, key, r, c + 1, startR, startC);
        computeDistinctIslands(grid, key, r, c - 1, startR, startC);
    }
}
