package com.wangqiuchen;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * 637.二叉树平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        
    }
}

class Solution {
    private List<Double> ans = new ArrayList<>();
    private List<Integer> count = new ArrayList<>();



    public List<Double> averageOfLevels(TreeNode root) {
        dfs(root,0);
        List<Double> average = new ArrayList<>();
        for (int i = 0;i<ans.size();i++){
            average.add(ans.get(i)/count.get(i));
        }
        return average;
    }

    //根结点，深度
    public void dfs(TreeNode root,int level){
        if (root == null){
            return;
        }

        if (level < ans.size()){
            ans.set(level,root.val +ans.get(level));
            count.set(level,count.get(level)+1);
        }else {
            ans.add(1.0*root.val);
            count.add(1);
        }

        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }

}