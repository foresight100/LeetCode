package com.wangqiuchen;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {
    List<Integer> ans = new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return ans;
    }

    private void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        ans.add(root.val);
        inOrder(root.right);
    }
}