package com.wangqiuchen;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ret;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null){
            return;
        }
        path.offerLast(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0){
            ret.add(new LinkedList<>(path));
        }
        dfs(root.left,sum);
        dfs(root.right,sum);
        path.pollLast();
    }
}
