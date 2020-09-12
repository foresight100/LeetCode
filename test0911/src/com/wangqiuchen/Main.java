package com.wangqiuchen;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(new Solution().combinationSum3(3,12));
    }
}

class Solution {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();


    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1, 9, k, n);
        return ans;
    }

    public void dfs(int cur, int n, int k, int sum) {
        if (temp.size() + (n - cur + 1) < k || temp.size() > k) {
            return;
        }
        if (temp.size() == k) {
            int tempSum = 0;
            for (int num : temp) {
                tempSum += num;
            }
            if (tempSum == sum) {
                ans.add(new ArrayList<Integer>(temp));
                return;
            }
        }
        //要这个数
        temp.add(cur);
        dfs(cur + 1, n, k, sum);
        //不要这个数
        temp.remove(temp.size() - 1);
        dfs(cur + 1, n, k, sum);
    }


}

//逐个检测
//class Solution {
//    List<Integer> temp = new ArrayList<Integer>();
//    List<List<Integer>> ans = new ArrayList<List<Integer>>();
//
//    public List<List<Integer>> combinationSum3(int k, int n) {
//        for (int mask = 0; mask < (1 << 9); ++mask) {
//            if (check(mask, k, n)) {
//                ans.add(new ArrayList<Integer>(temp));
//            }
//        }
//        return ans;
//    }
//
//    public boolean check(int mask, int k, int n) {
//        temp.clear();
//        for (int i = 0; i < 9; ++i) {
//            if (((1 << i) & mask) != 0) {
//                temp.add(i + 1);
//            }
//        }
//        if (temp.size() != k) {
//            return false;
//        }
//        int sum = 0;
//        for (int num : temp) {
//            sum += num;
//        }
//        return sum == n;
//    }
//}
