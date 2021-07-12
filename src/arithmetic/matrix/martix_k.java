package arithmetic.matrix;

import java.util.Scanner;

public class martix_k {
//  一道很弱智的题目，求倒数第k大  就是排序后倒数第k个数，
    //本质就是数数，目前这个解法是找到中间位，先painchu

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int K = in.nextInt();
        int l = 0;
        int h = M * N;
        //反向序号
        K = M * N - K + 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            // 假定以mid作为最大数的所在行curRow; 由矩阵的特点可知：
            // curRow的上一行所有的数都将小于mid，缩小查找范围
            int curRow = mid / M;
            // 同理，获取所在列curCol；
            int curCol = mid / N;
            int cnt = curRow * M + curCol * (N - curRow);
            // 剩下右下角一个小矩形
            for (int i = curRow + 1; i <= N; i++) {
                for (int j = curCol + 1; j <= M && (i * j <= mid); j++) {
                    cnt++;
                }
            }
            if (cnt >= K) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }
}
