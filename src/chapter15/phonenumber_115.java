package chapter15;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/7.
 * 翻译手机号码
 *输入由数字组成的字符串，
 * 输出数字代表的所有组合
 */
public class phonenumber_115 {
    public static void main(String[] args){
        ArrayList<String> l=new ArrayList<>();
        l=lettercomb("23");
        System.out.print(l.toString());
    }


    public static ArrayList<String> lettercomb(String nums){
        ArrayList<String> res=new ArrayList<>();
        res.add("");
        if(nums==null||nums.length()==0) return res;
        String[] letters={",","abc","def","ghi","jkl","mno","qprs",
        "tuv","wxyz"};
        for(int i=0;i<nums.length();i++){
            String s=letters[nums.charAt(i)-'0'];
            ArrayList<String> tmp=new ArrayList<>();
            for(int j=0;j<s.length();j++){
                //把对应字母加到结果集合中
                for(int k=0;k<res.size();k++)
                    tmp.add(res.get(k)+s.charAt(j));
            }
            res=tmp;
        }
        return res;
    }
}
