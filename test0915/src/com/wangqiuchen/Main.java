package com.wangqiuchen;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    //记录每行的数字使用情况
    private boolean[][] line = new boolean[9][9];
    //记录每列的数字使用情况
    private boolean[][] column = new boolean[9][9];
    //记录每块九宫格的数字使用情况
    private boolean[][][] block = new boolean[3][3][9];
    //是否填完
    private boolean valid = false;
    //记录空的格子
    private List<int[]> spaces = new ArrayList<int[]>();


    public void solveSudoku(char[][] board) {
        //初始化
        for (int i = 0;i < 9;++i){
            for (int j = 0;j < 9;++j){
                if (board[i][j] == '.'){
                    spaces.add(new int[]{i,j});
                }else {
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = true;
                }
            }
        }

        dfs(board,0);
    }

    public void dfs(char[][] board,int pos){
        //已经填完了
        if (pos == spaces.size()){
            valid = true;
            return;
        }
        //取到第pos个点的位置
        int[] space = spaces.get(pos);
        //取出点的位置
        int i = space[0], j = space[1];
        for (int digit = 0;digit < 9 && !valid;++digit){
            //如果没有在每行每列每个九宫格出现
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]){
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }

    }
}