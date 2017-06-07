package chapter15;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/6/7.
 * 全排列
 * 输入不含相同数字的序列，输出所有可能排列
 * 还需使用辅助数组记录他们的使用情况
 * 1、若含有重复元素
 */
public class allsort_119 {
    public static void main(String[] args){
        int[] a={1,2,3};
        ArrayList<ArrayList<Integer>> l=allsort(a);
        System.out.print(l.toString());
    }

    public static ArrayList<ArrayList<Integer>> allsort(int[] s){
        Arrays.sort(s);
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        boolean[] used=new boolean[s.length];
        helper(s,new ArrayList<>(),res,used);
        return res;
    }
    public static void helper(int[]s,ArrayList<Integer> subset,
                ArrayList<ArrayList<Integer>> res,boolean[] used){
        if(subset.size()==s.length){
            ArrayList<Integer> clone=new ArrayList<>(subset);
            res.add(clone);
            return;
        }
        for(int i=0;i<s.length;i++){
            if(used[i]) continue;
            //1//判断是否是重复元素的第一个
            if(used[i]||(i>0&&!used[i-1]&&s[i]==s[i-1])) continue;
            //1//
            subset.add(s[i]);
            used[i]=true;
            helper(s,subset,res,used);
            subset.remove(subset.size()-1);
            used[i]=false;
        }
    }
}
