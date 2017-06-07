package chapter15;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/6/7.
 * 输入不同数字的序列，输出所有可能集合
 * 1、若有重复元素，结果不能重复
 * 保留中间任意结果，而不是遍历完数列鄂菜保存结果
 * 利用完了数列的数之和，需要回退，恢复至使用前的状态
 */
public class subsets_118 {
public static void main(String[] args){
    ArrayList<ArrayList<Integer>> l=new ArrayList<ArrayList<Integer>>();
    int[] a={2,1,3};
    l=subsets(a);
    System.out.print(l.toString());
}

    public static ArrayList<ArrayList<Integer>> subsets(int[] s){
        Arrays.sort(s);
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        helper(s,0,new ArrayList<Integer>(),res);
        return res;

    }
    public static void helper(int[] s,int start,ArrayList<Integer> subset,
                              ArrayList<ArrayList<Integer>> res){
        if(start>s.length) return;
        ArrayList<Integer> clone=new ArrayList<>(subset);
        res.add(clone);
        for(int i=start;i<s.length;i++){
            //1//避免结果重复，只取第一个相同元素
            if(i!=start&&s[i]==s[i-1]) continue;
            //1//
            subset.add(s[i]);   //加入新元素，递归调用下一个元素
            helper(s,i+1,subset,res);
            subset.remove(subset.size()-1); //回退
        }
    }
}
