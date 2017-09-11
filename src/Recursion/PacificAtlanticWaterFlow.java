package Recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Lin on 2017/9/6.
 */
public class PacificAtlanticWaterFlow {
    public List<int[]> pacificAtlantic(int[][] matrix) {

        if(matrix == null || matrix.length == 0) return new ArrayList<>();

        List<int[]> res = new ArrayList<>();

        int row = matrix.length, col = matrix[0].length;
        int[][] visited = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();

        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                boolean isPeak = true;
                if(r - 1 >= 0 && matrix[r][c] < matrix[r - 1][c]) isPeak = false;
                if(r + 1 < row && matrix[r][c] < matrix[r + 1][c]) isPeak = false;
                if(c - 1 >= 0 && matrix[r][c] < matrix[r][c - 1]) isPeak = false;
                if(c + 1 < col && matrix[r][c] < matrix[r][c + 1]) isPeak = false;
                if(isPeak) queue.offer(new int[] {r, c});
            }
        }

        while(!queue.isEmpty()) {
            int[] loc = queue.poll();
            dfs(res, matrix, visited, loc[0], loc[1]);
        }

        return res;
    }

    private void dfs(List<int[]> res, int[][] matrix, int[][] visited, int r, int c) {

        boolean toTopLeft = false, toBottomRight = false;

        visited[r][c] = 1;

        int row = matrix.length, col = matrix[0].length;

        if(r == 0 || c == 0) toTopLeft = true;
        if(r == row - 1 || c == col - 1) toBottomRight = true;

        if(toTopLeft && toBottomRight) {
            visited[r][c] = 4;
            res.add(new int[] {r, c});
        }

        else {
            // 向上
            if(r - 1 >= 0 && matrix[r][c] >= matrix[r - 1][c]) {
                if(visited[r - 1][c] == 0) dfs(res, matrix, visited, r - 1, c);
                if(visited[r - 1][c] == 2 || visited[r - 1][c] == 4) toTopLeft = true;
                if(visited[r - 1][c] == 3 || visited[r - 1][c] == 4) toBottomRight = true;
            }

            // 向下
            if(r + 1 < row && matrix[r][c] >= matrix[r + 1][c]) {
                if(visited[r + 1][c] == 0) dfs(res, matrix, visited, r + 1, c);
                if(visited[r + 1][c] == 2 || visited[r + 1][c] == 4) toTopLeft = true;
                if(visited[r + 1][c] == 3 || visited[r + 1][c] == 4) toBottomRight = true;
            }

            // 向左
            if(c - 1 >= 0 && matrix[r][c] >= matrix[r][c - 1]) {
                if(visited[r][c - 1] == 0) dfs(res, matrix, visited, r, c - 1);
                if(visited[r][c - 1] == 2 || visited[r][c - 1] == 4) toTopLeft = true;
                if(visited[r][c - 1] == 3 || visited[r][c - 1] == 4) toBottomRight = true;
            }

            // 向右
            if(c + 1 < col && matrix[r][c] >= matrix[r][c + 1]) {
                if(visited[r][c + 1] == 0) dfs(res, matrix, visited, r, c + 1);
                if(visited[r][c + 1] == 2 || visited[r][c + 1] == 4) toTopLeft = true;
                if(visited[r][c + 1] == 3 || visited[r][c + 1] == 4) toBottomRight = true;
            }

            if(toTopLeft && toBottomRight){
                visited[r][c] = 4;
                res.add(new int[] {r, c});
            }

            else if(toTopLeft && !toBottomRight) visited[r][c] = 2;
            else if(!toTopLeft && toBottomRight) visited[r][c] = 3;
        }
    }
}
