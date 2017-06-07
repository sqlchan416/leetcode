package chapter15;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/7.
 *N皇后
 * N*N棋盘、放置N个皇后
 * 1到N的数列排序
 * 斜线上  两数之差等于其下表之差的绝对值
 */
public class nqueen_121 {
public static void main(String[] args){
    nqueen(8);
}
    public static  void nqueen(int n){
        ArrayList<Integer> sol=new ArrayList<>();
        boolean[] used=new boolean[n+1];    //从下表1开始
        //1到N的全排列
        nqueen(n,0,sol,used);

    }
    public static  void nqueen(int n,int start,ArrayList<Integer> sol,boolean[] used){
        if(start==n){
            System.out.println(sol.toString());
            return;
        }
        for(int i=1;i<=n;i++){
            if(used[i]) continue;  //不能重复使用
            if(!check(sol,i)) continue;
            sol.add(i);
            used[i]=true;
            nqueen(n,start+1,sol,used);
            sol.remove(sol.size()-1);
            used[i]=false;
        }
    }
    //判断是否在对角线上
    public static boolean check(ArrayList<Integer> sol,int q){
        for(int i=0;i<sol.size();i++){
            if(Math.abs(i-sol.size())==Math.abs(sol.get(i)-q)){
                return false;
            }
        }
        return true;
    }
}
