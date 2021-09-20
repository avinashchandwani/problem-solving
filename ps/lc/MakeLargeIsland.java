class MakeLargeIsland {
    int rows, columns;
    public int largestIsland(int[][] grid) {
        int color = 2;
        rows = grid.length;
        columns = grid[0].length;
        Map<Integer, Integer> islandArea = new HashMap<>();
        int maxAreaPossible = 0;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < columns; c++) {
                if(grid[r][c] == 1) {
                    islandArea.put(color, getIslandArea(grid, r, c, color));
                    color++;
                }
            }
        }
        boolean isZeroPresent = false;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < columns; c++) {
                if(grid[r][c] == 0) {
                  isZeroPresent = true;
                   maxAreaPossible = Math.max(maxAreaPossible, getMaxAreaPossible(grid, r, c, islandArea));
                }
            }
        }
        return isZeroPresent ? maxAreaPossible : rows * columns;
    }
    
    private int getMaxAreaPossible(int [][]grid, int r, int c, Map<Integer, Integer> islandArea) {
        Set<Integer> uniqueAdjcentIslands = new HashSet<>();
        int maxAreaPossible = 1;
        if(r > 0) uniqueAdjcentIslands.add(grid[r-1][c]);
        if(r < rows -1) uniqueAdjcentIslands.add(grid[r+1][c]);
        if(c > 0) uniqueAdjcentIslands.add(grid[r][c-1]);
        if(c < columns -1) uniqueAdjcentIslands.add(grid[r][c+1]);
        for(Integer island : uniqueAdjcentIslands){
            if(islandArea.containsKey(island)){
                 maxAreaPossible += islandArea.get(island);
            }
        }
        return maxAreaPossible;
    }
    
    private int getIslandArea(int [][]grid, int r, int c, int color) {
        if(r < 0 || r >= rows || c < 0 || c >= columns || grid[r][c] !=1) 
            return 0;
        grid[r][c] = color;
        return 1 + getIslandArea(grid, r + 1, c, color) + getIslandArea(grid, r - 1, c, color)
                + getIslandArea(grid, r, c + 1, color) + getIslandArea(grid, r, c-1, color);
    }
}
