package chapter15;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/6/7.
 * 组合和
 * 输入一组正整数、一个目标值，求所有可能组合
 * 1、输入序列中的数可以多次出现
 * 2、若序列可能有重复元素，每个元素只能用一次
 */
public class combinsum_117 {
public static void main(String[]args){
    ArrayList<ArrayList<Integer>> l=new ArrayList<ArrayList<Integer>>();
    int[] a={2,3,4,7};
    l=combinsum(a,7);
    System.out.print(l.toString());

}
    public static ArrayList<ArrayList<Integer>> combinsum(int[] nums,
                                                   int target){
        if(nums.length==0||target<=0) return null;
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        Arrays.sort(nums);

        helper(nums,0,target,new ArrayList<Integer>(),res);
        return res;

    }
    public static void helper(int[] nums,int start,int target,
                       ArrayList<Integer> path,
                       ArrayList<ArrayList<Integer>> res){
        if(target<0) return;
        if(target==0){
            ArrayList<Integer> result=new ArrayList<>(path);
            res.add(result);
        }else {
            for(int i=start;i<nums.length;i++){
                if(nums[i]>target) break;
                path.add(nums[i]);
                helper(nums,i,target-nums[i],path,res);
                path.remove(path.size()-1);
            }
        }
    }
}
