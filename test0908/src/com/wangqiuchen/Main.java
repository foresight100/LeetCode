package com.wangqiuchen;

import java.util.ArrayList;
import java.util.List;



public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> outPut = new ArrayList<>();
        List<Integer> temp = new ArrayList();


        return outPut;
    }

    public void consititute(int[] candidates,int target,List<List<Integer>> output,List<Integer> temp,int index){
        if (index == candidates.length){
            return;
        }

        if (target == 0){
            output.add(temp);
            return;
        }

        if (target-candidates[index] > 0){
            
        }
    }
}


//class Solution {
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> outPut = new ArrayList<>();
//        List<Integer> temp = new ArrayList();
//        consititute(candidates,target,outPut,temp,0);
//        return outPut;
//    }
//    public void consititute(int[] candidates,int target,List<List<Integer>> output,List<Integer> temp,int index){
//
//        if (index == candidates.length){
//            return;
//        }
//
//        if (target == 0){
//            output.add(new ArrayList<>(temp));
//            return;
//        }
//
//        consititute(candidates,target,output,temp,index+1);
//
//        if (target - candidates[index] >= 0){
//            temp.add(candidates[index]);
//            consititute(candidates,target-candidates[index],output,temp,index);
//            temp.remove(temp.size()-1);
//        }
//
//
//    }
//}