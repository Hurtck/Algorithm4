package lead_to_offer;

import leetcode.Tree;

public class Question14 {
    /**
     * t统计一个数的二进制中1的数量
     * 知识：1&1 = 1  1<<2 = 100 表示001左移两位 1>>2 = 0表示001左移两位
     * 思路：用1&n去判断每一位是不是01
     *
     */
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag!=0){
            if((n&flag)!=0) count++;
            flag = flag<<1;
        }
        return count;
    }
}
