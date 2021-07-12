package gongdao2021.martix;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * N皇后
 * 经典剪枝+回溯算法
 *  todo  还没再敲一遍
 * */
public class Nqueue {

    public  List<List<String>> solveNQueens(int n) {
        //判断 该列是否已经存在
        boolean[] cloumn=new boolean[n];
        //判断W-N 方向是否已经纯在
        boolean[] wn=new boolean[2*n-1];
        //判断E-N 方向是否已经纯在
        boolean[] ne=new boolean[2*n-1];
        List<List<String>> fin=new ArrayList<List<String>>();
        Stack<String> child=new Stack<String>();
        //n行 三个方向 cur行 stack
        backSum(fin,child,0,n,cloumn,wn,ne);
        return fin;
    }
    public  void backSum(List<List<String>> fin,Stack<String> child,int i,int n
            ,boolean[] cloumn,boolean[] wn,boolean[] ne ){
        //第 i 行 代表 祛除了所有不符合的条件
        if(i==n){
            //满足了条件，就将当前值放入fin
            fin.add(new ArrayList<String>(child));
            return;
        }
        for(int k=0;k<n;k++){
            //判断在斜列的位置
            if(!(wn[i+k]||ne[i+(n-k-1)]||cloumn[k])){
                cloumn[k]=true;
                wn[i+k]=true;
                ne[i+(n-k-1)]=true;
                //stack push 相关层的结果
                child.push(getString(n,k));
                //递归
                backSum(fin,child,i+1,n,cloumn,wn,ne);
                //回退当前这一层 代码 好换到别的位置
                child.pop();
                cloumn[k]=false;
                wn[i+k]=false;
                ne[i+(n-k-1)]=false;
            }

        }
    }

    //特殊输出专用
    public  String getString(int n,int target){
        StringBuffer temp=new StringBuffer("");
        for(int m=0;m<n;m++){
            if(m==target){
                temp.append("Q");
            }else {
                temp.append(".");
            }
        }
        return temp.toString();
    }

}
