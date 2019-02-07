package jianzhi_offer;

/**
 * @author weiyuwang
 * @since 2019/2/5 22:33
 */
public class Q64_1toN {
    public static void main(String[] args){
        System.out.println(caculate(10));
    }

    /**
     * 求 1+...+n 要求不能使用乘除法、for、while、if、else、switch、case等关键字
     * 及条件判断语句 A?B:C
     * @param n
     * @return
     */
    public static int caculate(int n) {
        int sum = n;
        boolean ans = (n > 0) && ((sum += caculate(n - 1)) > 0);
        return sum;
    }
}
