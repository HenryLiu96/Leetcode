package com.Leetcode.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LC200 {
    //number of island
    public int numIslands(char[][] grid){
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public void bfs(char[][] grid, int row, int col){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0')
                continue;
            for(int[] dir : directions){
                q.offer(new int[]{x + dir[0], y + dir[1]});
            }
            grid[x][y] = '0';
        }
    }
}
