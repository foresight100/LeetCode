package com.wangqiuchen;

public class Main {


    public static void main(String[] args) {
	// write your code here
    }

}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public TreeNode invert(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode right = invert(root.right);
        TreeNode left = invert(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}